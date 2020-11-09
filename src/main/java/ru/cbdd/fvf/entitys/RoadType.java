package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoadType extends AbstractEntity{

    // Тип дороги
    private String roadType;
}
