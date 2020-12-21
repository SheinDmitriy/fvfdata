package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class NetworkDB extends AbstractEntity {
    // ip
    private String ipAddress;

    // Маска
    private String mask;

    // Шлюз
    private String gateway;

    // Тип связи
    private Long linkType_id;

    // Оператор
    private Long operator_id;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("ip_address", "ipAddress");
        COLUMN_MAPPINGS.put("mask", "mask");
        COLUMN_MAPPINGS.put("gateway", "gateway");
        COLUMN_MAPPINGS.put("operator_id", "operator_id");
        COLUMN_MAPPINGS.put("link_type_id", "linkType_id");
    }
}
