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
    private NetworkService networkService;
    private DocumentsService documentsService;
    private OffenseService offenseService;
    private ComplexTypeService complexTypeService;
    private ComplexStatusService complexStatusService;
    private ComplexMarkService complexMarkService;
    private VerificationService verificationService;
    private BuhDataService buhDataService;

    @Autowired
    public ComplexService(IComplexDBProvider complexDBProvider, ComplexPlaceService complexPlaceService,
                          NetworkService networkService, DocumentsService documentsService, OffenseService offenseService,
                          ComplexTypeService complexTypeService, ComplexStatusService complexStatusService,
                          ComplexMarkService complexMarkService, VerificationService verificationService,
                          BuhDataService buhDataService) {
        this.complexDBProvider = complexDBProvider;
        this.complexPlaceService = complexPlaceService;
        this.networkService = networkService;
        this.documentsService = documentsService;
        this.offenseService = offenseService;
        this.complexTypeService = complexTypeService;
        this.complexStatusService = complexStatusService;
        this.complexMarkService = complexMarkService;
        this.verificationService = verificationService;
        this.buhDataService = buhDataService;
    }

    public List<Complex> findAll() {
        List<Complex> complex = new ArrayList<>();
        for (ComplexDB c: complexDBProvider.findAll()) {
            complex.add(makeComplex(c));
        }
        return complex;
    }

    private Complex makeComplex(ComplexDB complexDB) {

        return Complex.builder()
                .id(complexDB.getId())
                .complexName(complexDB.getComplexName())
                .seriesNumber(complexDB.getSeriesNumber())
                .complexPlace(complexPlaceService.findById(complexDB.getComplexPlace_id()))
                .network(networkService.findById(complexDB.getNetwork_id()))
                .documents(documentsService.findById(complexDB.getId()))
                .offenses(offenseService.findById(complexDB.getId()))
                .complexType(complexTypeService.findById(complexDB.getComplexType_id()))
                .complexStatus(complexStatusService.findById(complexDB.getComplexStatus_id()))
                .complexMark(complexMarkService.findById(complexDB.getComplexMark_id()))
                .verification(verificationService.findById(complexDB.getVerification_id()))
                .buhData(buhDataService.findById(complexDB.getBuhData_id()))
                .build();
    }

    public Complex findById(Long id){
        return makeComplex(complexDBProvider.findById(id));
    }
}
