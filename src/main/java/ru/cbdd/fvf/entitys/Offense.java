package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Offense extends AbstractEntity{

    // Тип нарушений
    private String typeOffense;
}
