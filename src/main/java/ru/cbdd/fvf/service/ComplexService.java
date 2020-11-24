package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Complex;
import ru.cbdd.fvf.interfaces.iproviders.IComplexProvider;

import java.util.List;

@Service
public class ComplexService {

    private IComplexProvider complexProvider;

    @Autowired
    public void setComplexProvider(IComplexProvider complexProvider) {
        this.complexProvider = complexProvider;
    }

    public List<Complex> findAll(){
        return complexProvider.findAll();
    }
}
