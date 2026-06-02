package com.residential.management.demo.residential.interfaces.rest.resources;

public record CreateBuildingResource(
        String name,
        String address,
        String district,
        String city
) {
}