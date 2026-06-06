package com.residential.management.demo.residential.interfaces.rest.transform;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.interfaces.rest.resources.CreateUnitResource;

public class CreateUnitFromResourceAssembler {

    public static Unit toEntityFromResource(CreateUnitResource resource, Building building) {
        return new Unit(
                building,
                resource.unitNumber(),
                resource.floor(),
                resource.coveredArea(),
                resource.totalArea(),
                resource.participationPercentage(),
                resource.distributionPercentage(),
                resource.status()
        );
    }
}