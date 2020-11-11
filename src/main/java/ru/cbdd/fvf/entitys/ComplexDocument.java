package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ComplexDocument extends AbstractEntity{

    private String path;
}
