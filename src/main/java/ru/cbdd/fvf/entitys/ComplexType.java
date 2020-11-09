package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ComplexType extends AbstractEntity {

    private String complexType;
}
