package com.residential.management.demo.residential.interfaces.rest.resources;

public record UnitResource(
        Long idUnit,
        Long idBuilding,
        Integer unitNumber,
        Integer floor,
        String status
) {
}