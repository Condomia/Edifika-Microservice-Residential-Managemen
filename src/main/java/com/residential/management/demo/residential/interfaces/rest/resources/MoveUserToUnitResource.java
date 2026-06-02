package com.residential.management.demo.residential.interfaces.rest.resources;

import java.time.LocalDateTime;

public record MoveUserToUnitResource(
        Long idUser,
        Long newIdUnit,
        LocalDateTime moveDate
) {
}