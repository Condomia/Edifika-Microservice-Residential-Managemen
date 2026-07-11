package com.residential.management.demo.residential.interfaces.rest.transform;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.interfaces.rest.resources.UpdateUnitResource;

public class UpdateUnitFromResourceAssembler {

    public static Unit toEntityFromResource(Unit unit,
                                            UpdateUnitResource resource,
                                            Building building) {

        unit.setBuilding(building);
        unit.setUnitNumber(resource.unitNumber());
        unit.setFloor(resource.floor());
        unit.setCoveredArea(resource.coveredArea());
        unit.setTotalArea(resource.totalArea());
        unit.setParticipationPercentage(resource.participationPercentage());
        unit.setDistributionPercentage(resource.distributionPercentage());
        unit.setStatus(resource.status());

        return unit;
    }

}