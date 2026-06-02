package com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}