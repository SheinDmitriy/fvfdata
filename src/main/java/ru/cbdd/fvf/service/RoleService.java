package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Role;
import ru.cbdd.fvf.interfaces.iproviders.IRoleProvider;

import java.util.List;

@Service
public class RoleService {

    private IRoleProvider roleProvider;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleProvider(IRoleProvider roleProvider) {
        this.roleProvider = roleProvider;
    }

    public List<Role> findAll() {
        return roleProvider.findAll();
    }

    public List<Role> findByUserId(Long id){
        return roleProvider.findByUserId(id);
    }

    public void save(String username, List<String> roles) {
        Long id = userService.findByUserName(username).getId();
        for (String r: roles) {
            roleProvider.save(id, roleProvider.findOneByName(r).getId());
        }
    }
}
