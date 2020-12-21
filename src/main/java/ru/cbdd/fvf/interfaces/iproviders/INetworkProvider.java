package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.NetworkDB;

public interface INetworkProvider {

    NetworkDB findById (Long id);
}
