package com.residential.management.demo.residential.interfaces.rest.transform;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.interfaces.rest.resources.BuildingResource;

public class BuildingResourceFromEntityAssembler {

    public static BuildingResource toResourceFromEntity(Building entity) {
        return new BuildingResource(
                entity.getIdBuilding(),
                entity.getName(),
                entity.getAddress(),
                entity.getDistrict(),
                entity.getCity()
        );
    }
}