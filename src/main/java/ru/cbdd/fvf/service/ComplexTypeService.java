package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.ComplexType;
import ru.cbdd.fvf.interfaces.iproviders.IComplexTypeProvider;

@Service
public class ComplexTypeService {

    private IComplexTypeProvider complexTypeProvider;

    @Autowired
    public ComplexTypeService(IComplexTypeProvider complexTypeProvider) {
        this.complexTypeProvider = complexTypeProvider;
    }

    public ComplexType findById(Long id) {
        return complexTypeProvider.findById(id);
    }
}
