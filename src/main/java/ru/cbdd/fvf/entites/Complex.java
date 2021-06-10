package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tcomplex")
public class Complex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series_number", unique = true, nullable = false)
    private String seriesNumber;

    @Column(name = "complex_name", nullable = false)
    private String complexName;

    @ManyToOne
    @JoinColumn(name = "complex_place_id")
    private ComplexPlace complexPlace;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "complex", fetch = FetchType.EAGER)
    private List<Documents> documents;

    @ManyToOne
    @JoinColumn(name = "network_id")
    private Network network;

    @ManyToMany
    @JoinTable(name = "tcomplex_offense",
            joinColumns = @JoinColumn(name = "complex_id"),
            inverseJoinColumns = @JoinColumn(name = "offense_id"))
    private List<Offense> offenses;

    @OneToOne
    @JoinColumn(name = "complex_type_id")
    private ComplexType complexType;

    @OneToOne
    @JoinColumn(name = "tverification")
    private Verification verification;

    @OneToOne
    @JoinColumn(name = "buh_data_id")
    private BuhData buhData;



}
