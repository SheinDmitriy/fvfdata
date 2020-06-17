package ru.cbdd.fvf.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.cbdd.fvf.entites.SystemUser;
import ru.cbdd.fvf.entites.User;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);
}
