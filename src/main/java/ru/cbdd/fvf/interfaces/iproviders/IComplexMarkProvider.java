package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.ComplexMark;

public interface IComplexMarkProvider {

    ComplexMark findById (Long id);
}
