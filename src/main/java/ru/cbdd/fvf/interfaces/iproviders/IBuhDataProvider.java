package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.BuhData;

public interface IBuhDataProvider {

    BuhData findById (Long id);
}
