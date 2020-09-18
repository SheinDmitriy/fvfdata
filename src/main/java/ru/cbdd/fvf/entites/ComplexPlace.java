package ru.cbdd.fvf.entites;

import javax.persistence.*;

@Entity
@Table(name = "ComplexPlace")
public class ComplexPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Место утсановки
    @Column(name = "place")
    private String place;

    // Широта
    @Column(name = "latitude")
    private String latitude;

    // Долгота
    @Column(name = "longitude")
    private String longitude;
}
