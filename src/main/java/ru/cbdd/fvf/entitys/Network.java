package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Network extends AbstractEntity{

    // ip
    private String ipAddress;

    // Маска
    private String mask;

    // Шлюз
    private String gateway;

    // Тип связи
    private Link link;

    // Оператор
    private Operator operator;
}
