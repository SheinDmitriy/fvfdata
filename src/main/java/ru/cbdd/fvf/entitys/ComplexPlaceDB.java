package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ComplexPlaceDB extends AbstractEntity{

    // Место утсановки
    private String place;

    // Широта
    private String latitude;

    // Долгота
    private String longitude;

    // Связь с типом дороги
    private Long roadType_id;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("latitude", "latitude");
        COLUMN_MAPPINGS.put("longitude", "longitude");
        COLUMN_MAPPINGS.put("road_type_id", "roadType_id");
    }
}
