package com.residential.management.demo.residential.domain.services;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.domain.model.entities.UserUnit;

import java.util.List;

public interface ResidentialQueryService {

    List<Building> getAllBuildings();

    List<Unit> getUnitsByBuildingId(Long idBuilding);

    List<UserUnit> getResidentsByBuildingId(Long idBuilding);
}