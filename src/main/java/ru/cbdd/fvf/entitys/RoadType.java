package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoadType extends AbstractEntity{

    // Тип дороги
    private String roadType;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("road_type", "roadType");
    }
}
