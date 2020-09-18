package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "complex_place")
@Data
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

    // Связь с типом дороги
    @ManyToOne
    @JoinColumn(name = "roadType_id")
    private RoadType roadType;
}
