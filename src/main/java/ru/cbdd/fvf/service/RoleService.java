package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Role;
import ru.cbdd.fvf.interfaces.iproviders.IRoleProvider;

import java.util.List;

@Service
public class RoleService {

    private IRoleProvider roleProvider;

    @Autowired
    public void setRoleProvider(IRoleProvider roleProvider) {
        this.roleProvider = roleProvider;
    }

    public List<Role> findAll() {
        return roleProvider.findAll();
    }
}
