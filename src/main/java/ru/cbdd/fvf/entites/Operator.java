package ru.cbdd.fvf.entites;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Operator {

    private Long id;

    private String title;

    private String contract;

    private LocalDateTime dateUntil;

}
