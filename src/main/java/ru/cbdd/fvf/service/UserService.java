package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cbdd.fvf.entitys.Role;
import ru.cbdd.fvf.entitys.SystemUser;
import ru.cbdd.fvf.entitys.User;
import ru.cbdd.fvf.interfaces.iproviders.IRoleProvider;
import ru.cbdd.fvf.interfaces.iproviders.IUserProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private IUserProvider userProvider;
    private IRoleProvider roleProvider;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setUserProvider(IUserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Autowired
    public void setRoleProvider(IRoleProvider roleProvider) {
        this.roleProvider = roleProvider;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User findByUserName(String username) {
        return userProvider.findByUsername(username);
    }

    @Transactional
    public boolean save(SystemUser systemUser) {
        User user = new User();

        if (findByUserName(systemUser.getUsername()) != null) {
            return false;
        }

        user.setUsername(systemUser.getUsername());
        user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        user.setRoles(Arrays.asList(roleProvider.findOneByName("ROLE_EMPLOYEE")));
        userProvider.save(user);
        return true;
    }

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userProvider.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(roleProvider.findByUserId(user.getId())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public List<User> findAll() {
        return userProvider.findAll();
    }

    public Optional<User> findById(Long id) {
        return userProvider.findById(id);
    }

    public Optional<User> findByIdSystemUser(Long id) {
        return userProvider.findById(id);
    }
}
