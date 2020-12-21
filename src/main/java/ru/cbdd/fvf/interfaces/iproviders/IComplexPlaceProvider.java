package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.ComplexPlaceDB;

public interface IComplexPlaceProvider {

    ComplexPlaceDB findById(Long id);
}
