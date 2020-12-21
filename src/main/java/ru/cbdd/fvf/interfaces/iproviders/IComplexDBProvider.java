package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Complex;
import ru.cbdd.fvf.entitys.ComplexDB;

import java.util.List;

public interface IComplexDBProvider {

        ComplexDB findById(Long id);

        List<ComplexDB> findAll();
}
