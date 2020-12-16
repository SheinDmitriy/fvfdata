package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class Operator extends AbstractEntity{

    private String title;

    private String contract;

    private LocalDateTime dateUntil;

    public static final Map<String, String> COLUMN_MAPPINGS = new HashMap<>();

    static {
        COLUMN_MAPPINGS.put("id", "id");
        COLUMN_MAPPINGS.put("title", "title");
        COLUMN_MAPPINGS.put("contract", "contract");
        COLUMN_MAPPINGS.put("date_until", "dateUntil");
    }

}
