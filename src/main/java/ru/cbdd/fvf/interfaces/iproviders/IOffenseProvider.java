package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Offense;

import java.util.List;

public interface IOffenseProvider {

    List<Offense> findById(Long id);
}
