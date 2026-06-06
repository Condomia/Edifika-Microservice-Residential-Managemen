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

    @Column(name = "covered_area", nullable = false)
    private Double coveredArea;

    @Column(name = "total_area", nullable = false)
    private Double totalArea;

    @Column(name = "participation_percentage", nullable = false)
    private Double participationPercentage;

    @Column(name = "distribution_percentage", nullable = false)
    private Double distributionPercentage;

    @Column(name = "status", nullable = false, length = 80)
    private String status;

    public Unit() {
    }

    public Unit(Building building, Integer unitNumber, Integer floor,
                Double coveredArea, Double totalArea,
                Double participationPercentage, Double distributionPercentage,
                String status) {
        this.building = building;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.coveredArea = coveredArea;
        this.totalArea = totalArea;
        this.participationPercentage = participationPercentage;
        this.distributionPercentage = distributionPercentage;
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

    public Double getCoveredArea() {
        return coveredArea;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public Double getParticipationPercentage() {
        return participationPercentage;
    }

    public Double getDistributionPercentage() {
        return distributionPercentage;
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

    public void setCoveredArea(Double coveredArea) {
        this.coveredArea = coveredArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public void setParticipationPercentage(Double participationPercentage) {
        this.participationPercentage = participationPercentage;
    }

    public void setDistributionPercentage(Double distributionPercentage) {
        this.distributionPercentage = distributionPercentage;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}