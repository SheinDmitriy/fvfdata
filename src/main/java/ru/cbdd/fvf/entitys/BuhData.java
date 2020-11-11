package ru.cbdd.fvf.entitys;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BuhData extends AbstractEntity {

    private String contractNumber;

    private LocalDateTime dataStartUp;

    private String inventoryNumber;

    private Double price;
}
