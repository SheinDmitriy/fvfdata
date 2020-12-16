package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Complex;

public interface IComplexDBProvider {

    Complex findById(Long id);
}
