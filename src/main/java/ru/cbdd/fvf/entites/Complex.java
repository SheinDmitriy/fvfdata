package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Complex")
public class Complex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series_number", unique = true, nullable = false)
    private String series_number;

    @Column(name = "complex_name", nullable = false)
    private String complex_name;

}
