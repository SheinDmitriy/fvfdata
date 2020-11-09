package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Verification extends AbstractEntity {

    private String verificationNumber;

    private LocalDateTime verificationDate;

    private LocalDateTime toVerificationDate;
}
