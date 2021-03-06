package ru.cbdd.fvf.entitys;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

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

    @Builder
    public ComplexPlace(String place, String latitude, String longitude, RoadType roadType, Long id) {
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
        this.roadType = roadType;
        this.id = id;
    }
}
