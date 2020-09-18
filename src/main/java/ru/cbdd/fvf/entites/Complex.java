package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "complex")
public class Complex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series_number", unique = true, nullable = false)
    private String series_number;

    @Column(name = "complex_name", nullable = false)
    private String complex_name;

    @ManyToOne
    @JoinColumn(name = "complex_place_id")
    private ComplexPlace complexPlace;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "document")
    private List<ComplexDocument> documents;

    @ManyToOne
    @JoinColumn(name = "network_id")
    private Network network;

}
