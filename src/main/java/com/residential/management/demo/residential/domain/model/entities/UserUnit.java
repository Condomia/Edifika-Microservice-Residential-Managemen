package com.residential.management.demo.residential.domain.model.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_unit")
public class UserUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_unit")
    private Long idUserUnit;

    @ManyToOne
    @JoinColumn(name = "id_unit", nullable = false)
    private Unit unit;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "status", nullable = false, length = 80)
    private String status;

    public UserUnit() {
    }

    public UserUnit(Unit unit, Long idUser, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.unit = unit;
        this.idUser = idUser;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getIdUserUnit() {
        return idUserUnit;
    }

    public Unit getUnit() {
        return unit;
    }

    public Long getIdUser() {
        return idUser;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}