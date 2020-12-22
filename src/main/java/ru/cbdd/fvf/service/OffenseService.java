package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Offense;
import ru.cbdd.fvf.interfaces.iproviders.IOffenseProvider;

import java.util.List;

@Service
public class OffenseService {

    private IOffenseProvider offenseProvider;

    @Autowired
    public OffenseService(IOffenseProvider offenseProvider) {
        this.offenseProvider = offenseProvider;
    }

    public List<Offense> findById(Long id) {
        return offenseProvider.findById(id);
    }
}
