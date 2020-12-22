package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.ComplexStatus;
import ru.cbdd.fvf.interfaces.iproviders.IComplexStatusProvider;

@Service
public class ComplexStatusService {

    private IComplexStatusProvider complexStatusProvider;

    @Autowired
    public ComplexStatusService(IComplexStatusProvider complexStatusProvider) {
        this.complexStatusProvider = complexStatusProvider;
    }


    public ComplexStatus findById(Long id) {
        return complexStatusProvider.findById(id);
    }
}
