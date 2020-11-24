package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class Complex extends AbstractEntity {

    private String seriesNumber;

    private String complexName;

    private ComplexPlace complexPlace;

    private List<Document> documents;

    private Network network;

    private List<Offense> offenses;

    private ComplexType complexType;

    private Verification verification;

    private BuhData buhData;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("complex_name", "complexName");
        COLUMN_MAPPINGS.put("series_number", "seriesNumber");
        COLUMN_MAPPINGS.put("complex_place_id", "complexPlace");
        COLUMN_MAPPINGS.put("network_id", "network");
        COLUMN_MAPPINGS.put("complex_type_id", "complexType");
        COLUMN_MAPPINGS.put("buh_data_id", "buhData");
        COLUMN_MAPPINGS.put("verification_id", "verification");
    }

}
