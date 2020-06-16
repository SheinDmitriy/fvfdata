package ru.cbdd.fvf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cbdd.fvf.entites.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String userName);
}
