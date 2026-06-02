package com.residential.management.demo.residential.domain.services;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.domain.model.entities.UserUnit;
import com.residential.management.demo.residential.interfaces.rest.resources.AssignUserToUnitResource;
import com.residential.management.demo.residential.interfaces.rest.resources.CreateBuildingResource;
import com.residential.management.demo.residential.interfaces.rest.resources.CreateUnitResource;
import com.residential.management.demo.residential.interfaces.rest.resources.MoveUserToUnitResource;

public interface ResidentialCommandService {

    Building createBuilding(CreateBuildingResource resource);

    Unit createUnit(CreateUnitResource resource);

    UserUnit assignUserToUnit(AssignUserToUnitResource resource);

    UserUnit moveUserToUnit(MoveUserToUnitResource resource);
}