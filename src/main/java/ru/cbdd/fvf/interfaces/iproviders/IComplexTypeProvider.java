package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.ComplexType;

public interface IComplexTypeProvider {

    ComplexType findById (Long id);
}
