package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ComplexPlace extends AbstractEntity{

    // Место утсановки
    private String place;

    // Широта
    private String latitude;

    // Долгота
    private String longitude;

    // Связь с типом дороги
    private RoadType roadType;
}
