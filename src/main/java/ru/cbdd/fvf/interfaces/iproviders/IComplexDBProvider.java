package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.ComplexDB;

import java.util.List;

public interface IComplexDBProvider {

    List<ComplexDB> findAll();
}
