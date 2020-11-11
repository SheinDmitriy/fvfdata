package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class BuhData extends AbstractEntity {

    private String contractNumber;

    private LocalDateTime dataStartUp;

    private String inventoryNumber;

    private Double price;
}
