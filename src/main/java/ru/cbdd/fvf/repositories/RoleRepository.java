package ru.cbdd.fvf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cbdd.fvf.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
