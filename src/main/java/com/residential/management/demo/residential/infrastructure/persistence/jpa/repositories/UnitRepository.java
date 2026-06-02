package com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories;

import com.residential.management.demo.residential.domain.model.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByBuildingIdBuilding(Long idBuilding);
}