package ru.cbdd.fvf.entites;

import lombok.Data;

@Data
public class ComplexDocument {

    private Long id;

    private Complex complex;

    private String path;
}
