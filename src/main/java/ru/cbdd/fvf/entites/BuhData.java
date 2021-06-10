package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbuh_data")
public class BuhData  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "data_startup")
    private LocalDateTime dataStartUp;

    @Column(name = "inventory_number")
    private String inventoryNumber;
}
