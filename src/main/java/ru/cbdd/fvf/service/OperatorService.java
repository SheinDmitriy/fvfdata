package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Operator;
import ru.cbdd.fvf.interfaces.iproviders.IOperatorProvider;

@Service
public class OperatorService {

    private IOperatorProvider operatorProvider;

    @Autowired
    public OperatorService(IOperatorProvider operatorProvider) {
        this.operatorProvider = operatorProvider;
    }

    public Operator findById(Long id) {
        return operatorProvider.findById(id);
    }
}
