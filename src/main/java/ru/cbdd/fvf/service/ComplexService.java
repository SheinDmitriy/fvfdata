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
    private ComplexPlaceService complexPlaceService;

    @Autowired
    public ComplexService(IComplexDBProvider complexDBProvider, ComplexPlaceService complexPlaceService) {
        this.complexDBProvider = complexDBProvider;
        this.complexPlaceService = complexPlaceService;
    }

//    public List<Complex> findAll() {
//        List<Complex> complex = new ArrayList<>();
//        for (ComplexDB c: complexDBProvider.findAll()) {
//            complex.add(makeComplex(c));
//        }
//        return complex;
//    }
//
//    private Complex makeComplex(ComplexDB complexDB) {
//
//        return Complex.builder()
//                .id(complexDB.getId())
//                .complexName(complexDB.getComplexName())
//                .seriesNumber(complexDB.getSeriesNumber())
//                .complexPlace(complexPlaceService.findById(complexDB.getComplexPlace_id()))
//                .build();
//    }

    public ComplexDB findById(){
        return complexDBProvider.findById(1l);
    }
}
