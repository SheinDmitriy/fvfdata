package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.ComplexStatus;

public interface IComplexStatusProvider {

    ComplexStatus findById (Long id);
}
