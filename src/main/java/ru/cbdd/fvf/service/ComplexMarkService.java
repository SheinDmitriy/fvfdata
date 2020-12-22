package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.ComplexMark;
import ru.cbdd.fvf.interfaces.iproviders.IComplexMarkProvider;

@Service
public class ComplexMarkService {

    private IComplexMarkProvider complexMarkProvider;

    @Autowired
    public ComplexMarkService(IComplexMarkProvider complexMarkProvider) {
        this.complexMarkProvider = complexMarkProvider;
    }

    public ComplexMark findById(Long id) {
        return  complexMarkProvider.findById(id);
    }
}
