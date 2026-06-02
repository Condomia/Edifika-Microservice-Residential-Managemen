package com.residential.management.demo.residential.domain.model.entities;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import jakarta.persistence.*;

@Entity
@Table(name = "unit")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unit")
    private Long idUnit;

    @ManyToOne
    @JoinColumn(name = "id_building", nullable = false)
    private Building building;

    @Column(name = "unit_number", nullable = false)
    private Integer unitNumber;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "status", nullable = false, length = 80)
    private String status;

    public Unit() {
    }

    public Unit(Building building, Integer unitNumber, Integer floor, String status) {
        this.building = building;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.status = status;
    }

    public Long getIdUnit() {
        return idUnit;
    }

    public Building getBuilding() {
        return building;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public Integer getFloor() {
        return floor;
    }

    public String getStatus() {
        return status;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}