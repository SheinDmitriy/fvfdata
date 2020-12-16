package ru.cbdd.fvf.entitys;

import lombok.Builder;
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

    private ComplexStatus complexStatus;

    private ComplexMark complexMark;

    private Verification verification;

    private BuhData buhData;

    @Builder
    public Complex(String seriesNumber, String complexName, ComplexPlace complexPlace, List<Document> documents,
                   Network network, List<Offense> offenses, ComplexType complexType, ComplexStatus complexStatus,
                   ComplexMark complexMark, Verification verification, BuhData buhData, Long id) {
        this.seriesNumber = seriesNumber;
        this.complexName = complexName;
        this.complexPlace = complexPlace;
        this.documents = documents;
        this.network = network;
        this.offenses = offenses;
        this.complexType = complexType;
        this.complexStatus = complexStatus;
        this.complexMark = complexMark;
        this.verification = verification;
        this.buhData = buhData;
        this.id = id;
    }

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("complex_name", "complexName");
        COLUMN_MAPPINGS.put("series_number", "seriesNumber");
        COLUMN_MAPPINGS.put("complex_place_id", "complexPlace");
        COLUMN_MAPPINGS.put("network_id", "network");
        COLUMN_MAPPINGS.put("complex_type_id", "complexType");
        COLUMN_MAPPINGS.put("complex_mark_id", "complexMark");
        COLUMN_MAPPINGS.put("complex_status_id", "complexStatus");
        COLUMN_MAPPINGS.put("buh_data_id", "buhData");
        COLUMN_MAPPINGS.put("verification_id", "verification");
    }
}
