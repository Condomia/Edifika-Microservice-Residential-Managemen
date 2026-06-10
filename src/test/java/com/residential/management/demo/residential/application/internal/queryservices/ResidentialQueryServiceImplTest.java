package com.residential.management.demo.residential.application.internal.queryservices;

import com.residential.management.demo.residential.domain.model.aggregates.Building;
import com.residential.management.demo.residential.domain.model.entities.Unit;
import com.residential.management.demo.residential.domain.model.entities.UserUnit;
import com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories.BuildingRepository;
import com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories.UnitRepository;
import com.residential.management.demo.residential.infrastructure.persistence.jpa.repositories.UserUnitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ResidentialQueryServiceImplTest {

    @Mock
    private BuildingRepository buildingRepository;

    @Mock
    private UnitRepository unitRepository;

    @Mock
    private UserUnitRepository userUnitRepository;

    @InjectMocks
    private ResidentialQueryServiceImpl residentialQueryService;

    @Test
    void getAllBuildingsSuccessfully() {
        var building1 = mock(Building.class);
        var building2 = mock(Building.class);

        var buildings = List.of(building1, building2);

        when(buildingRepository.findAll())
                .thenReturn(buildings);

        var result = residentialQueryService.getAllBuildings();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(buildings, result);

        verify(buildingRepository, times(1)).findAll();
    }

    @Test
    void getUnitsByBuildingIdSuccessfully() {
        var unit1 = mock(Unit.class);
        var unit2 = mock(Unit.class);

        var units = List.of(unit1, unit2);

        when(unitRepository.findByBuildingIdBuilding(1L))
                .thenReturn(units);

        var result = residentialQueryService.getUnitsByBuildingId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(units, result);

        verify(unitRepository, times(1))
                .findByBuildingIdBuilding(1L);
    }

    @Test
    void getResidentsByBuildingIdSuccessfully() {
        var resident1 = mock(UserUnit.class);
        var resident2 = mock(UserUnit.class);

        var residents = List.of(resident1, resident2);

        when(userUnitRepository.findByUnitBuildingIdBuilding(1L))
                .thenReturn(residents);

        var result = residentialQueryService.getResidentsByBuildingId(1L);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(residents, result);

        verify(userUnitRepository, times(1))
                .findByUnitBuildingIdBuilding(1L);
    }
}