package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Complex extends AbstractEntity {

    private String seriesNumber;

    private String complexName;

    private ComplexPlace complexPlace;

    private List<ComplexDocument> documents;

    private Network network;

    private List<Offense> offenses;

    private ComplexType complexType;

    private Verification verification;

    private BuhData buhData;

}
