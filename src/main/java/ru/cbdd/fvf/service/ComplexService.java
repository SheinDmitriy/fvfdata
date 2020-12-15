package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Complex;
import ru.cbdd.fvf.entitys.ComplexDB;
import ru.cbdd.fvf.interfaces.iproviders.IComplexDBProvider;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComplexService {

    private IComplexDBProvider complexDBProvider;

    @Autowired
    public void setComplexDBProvider(IComplexDBProvider complexDBProvider) {
        this.complexDBProvider = complexDBProvider;
    }

    public List<Complex> findAll() {
        List<Complex> complex = new ArrayList<>();
        for (ComplexDB c: complexDBProvider.findAll()) {
            complex.add(makeComplex(c));
        }
        return complex;
    }

    private Complex makeComplex(ComplexDB complexDB) {
        Complex complex = new Complex();

        return complex;
    }
}
