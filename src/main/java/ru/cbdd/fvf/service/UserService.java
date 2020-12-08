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
import ru.cbdd.fvf.interfaces.iproviders.IUserProvider;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private IUserProvider userProvider;
    private RoleService roleService;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void setUserProvider(IUserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User findByUserName(String username) {
        return makeUser(userProvider.findByUsername(username));
    }

    @Transactional
    public boolean save(SystemUser systemUser) {
        User user = new User();

        if (findByUserName(systemUser.getUsername()) != null) {
            return false;
        }

        user.setUsername(systemUser.getUsername());
        user.setPassword(passwordEncoder.encode(systemUser.getPassword()));
        userProvider.save(user);
        roleService.save(user.getUsername(), systemUser.getRoles());
        return true;
    }

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userProvider.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public List<User> findAll() {
        List<User> users = userProvider.findAll();
        for (User u: users) {
            makeUser(u);
        }
        return users;
    }

    public User findById(Long id) {
        return makeUser(userProvider.findById(id));
    }

    private User makeUser(User user){
         user.setRoles(roleService.findByUserId(user.getId()));
         return user;
    }

//    public Optional<User> findByIdSystemUser(Long id) {
//        return userProvider.findById(id);
//    }
}
