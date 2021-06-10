package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tcomplex_type")
public class ComplexType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "mark")
    private String mark;

    @ManyToOne
    @JoinColumn(name = "ststus_id")
    private ComplexStatus status;
}
