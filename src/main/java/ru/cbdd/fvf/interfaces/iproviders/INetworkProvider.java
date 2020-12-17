package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Network;

public interface INetworkProvider {

    Network findById (Long id);
}
