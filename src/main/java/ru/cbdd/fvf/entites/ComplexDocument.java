package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "complex_document")
@Data
public class ComplexDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "complex_id")
    private Complex complex;

    @Column(name = "path")
    private String path;
}
