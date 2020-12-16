package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.ComplexPlace;

public interface IComplexPlaceProvider {

    ComplexPlace findById(Long id);
}
