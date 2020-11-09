package ru.cbdd.fvf.entites;

import lombok.Data;

@Data
public class Network {

    private Long id;

    // ip
    private String ipAddress;

    // Маска
    private String mask;

    // Шлюз
    private String gateway;

    private Link link;

    private Operator operator;
}
