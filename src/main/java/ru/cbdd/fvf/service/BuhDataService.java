package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.BuhData;
import ru.cbdd.fvf.interfaces.iproviders.IBuhDataProvider;

@Service
public class BuhDataService {

    private IBuhDataProvider buhDataProvider;

    @Autowired
    public BuhDataService(IBuhDataProvider buhDataProvider) {
        this.buhDataProvider = buhDataProvider;
    }

    public BuhData findById(Long id) {
        return buhDataProvider.findById(id);
    }
}
