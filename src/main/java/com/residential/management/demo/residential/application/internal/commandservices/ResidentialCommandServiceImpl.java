package com.residential.management.demo.residential.application.internal.commandservices;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.domain.model.entities.UserUnit;
import com.residential.management.demo.residential.domain.services.ResidentialCommandService;
import com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories.BuildingRepository;
import com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories.UnitRepository;
import com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories.UserUnitRepository;
import com.residential.management.demo.residential.interfaces.rest.resources.*;
import com.residential.management.demo.residential.interfaces.rest.transform.AssignUserToUnitFromResourceAssembler;
import com.residential.management.demo.residential.interfaces.rest.transform.CreateBuildingFromResourceAssembler;
import com.residential.management.demo.residential.interfaces.rest.transform.CreateUnitFromResourceAssembler;
import com.residential.management.demo.residential.interfaces.rest.transform.UpdateUnitFromResourceAssembler;
import org.springframework.stereotype.Service;

@Service
public class ResidentialCommandServiceImpl implements ResidentialCommandService {

    private final BuildingRepository buildingRepository;
    private final UnitRepository unitRepository;
    private final UserUnitRepository userUnitRepository;



    public ResidentialCommandServiceImpl(
            BuildingRepository buildingRepository,
            UnitRepository unitRepository,
            UserUnitRepository userUnitRepository
    ) {
        this.buildingRepository = buildingRepository;
        this.unitRepository = unitRepository;
        this.userUnitRepository = userUnitRepository;
    }

    @Override
    public Building createBuilding(CreateBuildingResource resource) {
        var building = CreateBuildingFromResourceAssembler.toEntityFromResource(resource);
        return buildingRepository.save(building);
    }

    @Override
    public Unit createUnit(CreateUnitResource resource) {
        var building = buildingRepository.findById(resource.idBuilding())
                .orElseThrow(() -> new RuntimeException("Building not found"));

        var unit = CreateUnitFromResourceAssembler.toEntityFromResource(resource, building);
        return unitRepository.save(unit);
    }

    @Override
    public UserUnit assignUserToUnit(AssignUserToUnitResource resource) {
        var unit = unitRepository.findById(resource.idUnit())
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        var existingAssignment = userUnitRepository
                .findByIdUserAndUnitIdUnit(resource.idUser(), resource.idUnit());

        if (existingAssignment.isPresent()) {
            throw new RuntimeException("User is already assigned to this unit");
        }

        var userUnit = AssignUserToUnitFromResourceAssembler.toEntityFromResource(resource, unit);
        return userUnitRepository.save(userUnit);
    }


    @Override
    public UserUnit moveUserToUnit(MoveUserToUnitResource resource) {
        var currentAssignment = userUnitRepository
                .findByIdUserAndStatus(resource.idUser(), "ACTIVE")
                .orElseThrow(() -> new RuntimeException("Active assignment not found for this user"));

        currentAssignment.setEndDate(resource.moveDate());
        currentAssignment.setStatus("INACTIVE");
        userUnitRepository.save(currentAssignment);

        var newUnit = unitRepository.findById(resource.newIdUnit())
                .orElseThrow(() -> new RuntimeException("New unit not found"));

        var newAssignment = new UserUnit(
                newUnit,
                resource.idUser(),
                resource.moveDate(),
                null,
                "ACTIVE"
        );

        return userUnitRepository.save(newAssignment);
    }
    @Override
    public Unit updateUnit(Long idUnit, UpdateUnitResource resource) {

        var unit = unitRepository.findById(idUnit)
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        var building = buildingRepository.findById(resource.idBuilding())
                .orElseThrow(() -> new RuntimeException("Building not found"));

        UpdateUnitFromResourceAssembler.toEntityFromResource(unit, resource, building);

        return unitRepository.save(unit);
    }
}