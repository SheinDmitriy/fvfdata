package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.RoadType;
import ru.cbdd.fvf.interfaces.iproviders.IRoadTypeProvider;

@Service
public class RoadTypeService {

    private IRoadTypeProvider roadTypeProvider;

    @Autowired
    public RoadTypeService(IRoadTypeProvider roadTypeProvider) {
        this.roadTypeProvider = roadTypeProvider;
    }

    public RoadType findById(Long id) {
        return roadTypeProvider.findById(id);
    }
}
