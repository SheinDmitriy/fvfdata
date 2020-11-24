package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Role;

import java.util.List;

public interface IRoleProvider {

    Role findOneByName(String roleName);

    List<Role> findByUserId(Long id);

    List<Role> findAll();
}
