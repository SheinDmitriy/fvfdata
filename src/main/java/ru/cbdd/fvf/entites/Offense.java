package ru.cbdd.fvf.entites;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "toffense")
public class Offense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Тип нарушений
    @Column(name = "type_offense")
    private String typeOffense;
}