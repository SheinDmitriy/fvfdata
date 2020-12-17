package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Operator;

public interface IOperatorProvider {

    Operator findById (Long id);
}
