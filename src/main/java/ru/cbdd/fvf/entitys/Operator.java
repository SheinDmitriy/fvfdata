package ru.cbdd.fvf.entitys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Operator extends AbstractEntity{

    private String title;

    private String contract;

    private LocalDateTime dateUntil;

}
