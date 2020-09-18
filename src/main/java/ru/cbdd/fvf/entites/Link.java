package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "link")
@Data
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "link_type")
    private String link_type;
}
