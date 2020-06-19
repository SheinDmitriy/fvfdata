package ru.cbdd.fvf.entites;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Complex")
public class Complex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series_number", unique = true, nullable = false)
    private String series_number;

    @Column(name = "complex_name", nullable = false)
    private String complex_name;

    @Column(name = "ip_address", unique = true)
    private String ip_address;

    public Complex() {
    }

    public Complex(String series_number, String complex_name, String ip_address) {
        this.series_number = series_number;
        this.complex_name = complex_name;
        this.ip_address = ip_address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeries_number() {
        return series_number;
    }

    public void setSeries_number(String series_number) {
        this.series_number = series_number;
    }

    public String getComplex_name() {
        return complex_name;
    }

    public void setComplex_name(String complex_name) {
        this.complex_name = complex_name;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
