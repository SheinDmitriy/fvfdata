package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.ComplexPlace;
import ru.cbdd.fvf.entitys.ComplexPlaceDB;
import ru.cbdd.fvf.interfaces.iproviders.IComplexPlaceProvider;

@Service
public class ComplexPlaceService {

    private IComplexPlaceProvider complexPlaceProvider;
    private RoadTypeService roadTypeService;

    @Autowired
    public ComplexPlaceService(IComplexPlaceProvider complexPlaceProvider, RoadTypeService roadTypeService) {
        this.complexPlaceProvider = complexPlaceProvider;
        this.roadTypeService = roadTypeService;
    }

    public ComplexPlace findById(Long id) {
        return makeComplexPlace(complexPlaceProvider.findById(id));

    }

    private ComplexPlace makeComplexPlace(ComplexPlaceDB complexPlaceDB) {
        return ComplexPlace.builder()
                    .id(complexPlaceDB.getId())
                    .latitude(complexPlaceDB.getLatitude())
                    .longitude(complexPlaceDB.getLongitude())
                    .roadType(roadTypeService.findById(complexPlaceDB.getRoadType_id()))
                    .place(complexPlaceDB.getPlace())
                    .build();
    }
}
