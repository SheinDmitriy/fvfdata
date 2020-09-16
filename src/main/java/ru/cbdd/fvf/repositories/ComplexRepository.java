package ru.cbdd.fvf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cbdd.fvf.entites.Complex;

@Repository
public interface ComplexRepository extends JpaRepository<Complex, Long> {
}
