package com.residential.management.demo.residential.interfaces.rest.resources;

public record CreateUnitResource(
        Long idBuilding,
        Integer unitNumber,
        Integer floor,
        String status
) {
}