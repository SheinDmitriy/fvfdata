package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tcomplex_status")
public class ComplexStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;
}
