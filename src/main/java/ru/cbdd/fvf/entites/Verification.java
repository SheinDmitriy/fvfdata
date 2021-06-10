package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tverification")
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "verification_number")
    private String verificationNumber;

    @Column(name = "verification_date")
    private LocalDateTime verificationDate;

    @Column(name = "verification_date_until")
    private LocalDateTime verificationDateUntil;
}
