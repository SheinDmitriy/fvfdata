package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class ComplexDB extends AbstractEntity{

    private String seriesNumber;

    private String complexName;

    private Long complexPlace_id;

    private Long network_id;

    private Long complexType_id;

    private Long verification_id;

    private Long buhData_id;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("complex_name", "complexName");
        COLUMN_MAPPINGS.put("series_number", "seriesNumber");
        COLUMN_MAPPINGS.put("complex_place_id", "complexPlace_id");
        COLUMN_MAPPINGS.put("network_id", "network_id");
        COLUMN_MAPPINGS.put("complex_type_id", "complexType_id");
        COLUMN_MAPPINGS.put("buh_data_id", "buhData_id");
        COLUMN_MAPPINGS.put("verification_id", "verification_id");
    }

}
