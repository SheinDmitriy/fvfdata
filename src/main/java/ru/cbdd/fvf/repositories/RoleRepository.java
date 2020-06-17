package ru.cbdd.fvf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cbdd.fvf.entites.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findOneByName(String theRoleName);
}
