package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.User;

import java.util.List;

public interface IUserProvider {
    User findByUsername(String username);

    void save (User user);

    List<User> findAll();

    User findById(Long id);
}
