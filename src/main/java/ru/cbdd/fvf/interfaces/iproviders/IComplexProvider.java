package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Complex;

import java.util.List;

public interface IComplexProvider {
    List<Complex> findAll();
}
