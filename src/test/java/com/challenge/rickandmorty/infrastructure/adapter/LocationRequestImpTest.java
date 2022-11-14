package com.challenge.rickandmorty.infrastructure.adapter;

import com.challenge.rickandmorty.infrastructure.adapter.gateway.LocationRequest;
import com.challenge.rickandmorty.domain.model.Location;

import com.challenge.rickandmorty.infrastructure.mocks.LocationMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationRequestImpTest {

    @Mock
    LocationRequest location;

    private static final String originUrl = "https://rickandmortyapi.com/api/location/1";


    @BeforeEach
    void setup(){
        Location locationData = LocationMock.getLocationTest();
        when(location.getLocationByUrl(originUrl))
                .thenReturn(locationData);
    }

    @Test
    void shouldGetLocationIsNameEarth(){
        Location locationExt = location.getLocationByUrl(originUrl);
        assertEquals("Earth (C-137)", locationExt.getName());
    }

    @Test
    void shouldGetLocationIsTypePlanet(){
        Location locationMock = location.getLocationByUrl(originUrl);
        assertEquals("Planet", locationMock.getType());
    }
}
