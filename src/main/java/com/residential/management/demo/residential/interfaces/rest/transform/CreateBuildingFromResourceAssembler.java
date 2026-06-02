package com.residential.management.demo.residential.interfaces.rest.transform;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.interfaces.rest.resources.CreateBuildingResource;

public class CreateBuildingFromResourceAssembler {

    public static Building toEntityFromResource(CreateBuildingResource resource) {
        return new Building(
                resource.name(),
                resource.address(),
                resource.district(),
                resource.city()
        );
    }
}