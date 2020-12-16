package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class BuhData extends AbstractEntity {

    private String contractNumber;

    private LocalDateTime dataStartUp;

    private String inventoryNumber;

    private Double price;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("contract_number", "contractNumber");
        COLUMN_MAPPINGS.put("data_start_up", "dataStartUp");
        COLUMN_MAPPINGS.put("inventory_number", "inventoryNumber");
        COLUMN_MAPPINGS.put("price", "price");
    }
}
