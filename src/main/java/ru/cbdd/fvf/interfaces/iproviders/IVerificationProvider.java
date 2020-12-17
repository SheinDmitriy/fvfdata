package ru.cbdd.fvf.interfaces.iproviders;

import ru.cbdd.fvf.entitys.Verification;

public interface IVerificationProvider {

    Verification findById (Long id);
}
