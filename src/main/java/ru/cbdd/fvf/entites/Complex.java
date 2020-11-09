package ru.cbdd.fvf.entites;

import lombok.Data;
import java.util.List;

@Data
public class Complex {

    private Long id;

    private String series_number;

    private String complex_name;

    private ComplexPlace complexPlace;

    private List<ComplexDocument> documents;

    private Network network;

}
