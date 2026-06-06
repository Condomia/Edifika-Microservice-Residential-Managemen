package com.residential.management.demo.residential.interfaces.rest.transform;

import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.interfaces.rest.resources.UnitResource;

public class UnitResourceFromEntityAssembler {

    public static UnitResource toResourceFromEntity(Unit entity) {
        return new UnitResource(
                entity.getIdUnit(),
                entity.getBuilding().getIdBuilding(),
                entity.getUnitNumber(),
                entity.getFloor(),
                entity.getCoveredArea(),
                entity.getTotalArea(),
                entity.getParticipationPercentage(),
                entity.getDistributionPercentage(),
                entity.getStatus()
        );
    }
}