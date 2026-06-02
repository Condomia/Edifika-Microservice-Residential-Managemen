package com.residential.management.demo.residential.domain.model.aggregates;


import jakarta.persistence.*;

@Entity
@Table(name = "building")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_building")
    private Long idBuilding;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "address", nullable = false, length = 80)
    private String address;

    @Column(name = "district", nullable = false, length = 80)
    private String district;

    @Column(name = "city", nullable = false, length = 80)
    private String city;

    public Building() {
    }

    public Building(String name, String address, String district, String city) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.city = city;
    }

    public Long getIdBuilding() {
        return idBuilding;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }
}