package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.RoadType;

public interface IRoadTypeProvider {

    RoadType findById (Long id);
}
