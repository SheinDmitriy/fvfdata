package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class Verification extends AbstractEntity {

    private String verificationNumber;

    private LocalDateTime verificationDate;

    private LocalDateTime verificationDateUntil;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("verification_number", "verificationNumber");
        COLUMN_MAPPINGS.put("verification_date", "verificationDate");
        COLUMN_MAPPINGS.put("verification_date_until", "verificationDateUntil");
    }
}
