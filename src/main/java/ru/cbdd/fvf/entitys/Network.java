package ru.cbdd.fvf.entitys;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

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
    private LinkType linkType;

    // Оператор
    private Operator operator;

    @Builder
    public Network(String ipAddress, String mask, String gateway, LinkType linkType, Operator operator, Long id) {
        this.ipAddress = ipAddress;
        this.mask = mask;
        this.gateway = gateway;
        this.linkType = linkType;
        this.operator = operator;
        this.id = id;
    }
}
