package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roadType")
@Data
public class RoadType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Тип дороги
    @Column(name = "roadType")
    private String roadType;
}
