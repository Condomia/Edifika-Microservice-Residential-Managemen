package com.residential.management.demo.residential.interfaces.rest.resources;

public record BuildingResource(
        Long idBuilding,
        String name,
        String address,
        String district,
        String city
) {
}