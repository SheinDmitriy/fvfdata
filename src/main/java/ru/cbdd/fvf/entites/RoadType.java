package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "road_type")
@Data
public class RoadType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Тип дороги
    @Column(name = "road_type")
    private String roadType;
}
