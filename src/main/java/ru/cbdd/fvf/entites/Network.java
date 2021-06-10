package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tnetwork")
@Data
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // ip
    @Column(name = "ip_address")
    private String ipAddress;

    // Маска
    @Column(name = "mask")
    private String mask;

    // Шлюз
    @Column(name = "gateway")
    private String gateway;

    @ManyToOne
    @JoinColumn(name = "link_id")
    private LinkType linkType;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;
}
