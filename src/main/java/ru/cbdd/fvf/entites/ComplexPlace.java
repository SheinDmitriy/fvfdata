package ru.cbdd.fvf.entites;

import lombok.Data;

@Data
public class ComplexPlace {

    private Long id;

    // Место утсановки
    private String place;

    // Широта
    private String latitude;

    // Долгота
    private String longitude;

    // Связь с типом дороги
    private RoadType roadType;
}
