package ru.cbdd.fvf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbdd.fvf.entitys.Verification;
import ru.cbdd.fvf.interfaces.iproviders.IVerificationProvider;

@Service
public class VerificationService {

    private IVerificationProvider verificationProvider;

    @Autowired
    public VerificationService(IVerificationProvider verificationProvider) {
        this.verificationProvider = verificationProvider;
    }

    public Verification findById(Long id) {
        return verificationProvider.findById(id);
    }
}
