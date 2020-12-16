package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.interfaces.iproviders.IComplexPlaceProvider;

@Service
public class ComplexPlaceService {

    private IComplexPlaceProvider complexPlaceProvider;

    @Autowired
    public ComplexPlaceService(IComplexPlaceProvider complexPlaceProvider) {
        this.complexPlaceProvider = complexPlaceProvider;
    }
}
