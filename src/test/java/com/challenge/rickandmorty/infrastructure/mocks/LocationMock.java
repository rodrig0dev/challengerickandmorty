package com.challenge.rickandmorty.infrastructure.mocks;

import com.challenge.rickandmorty.domain.model.Location;

import java.time.LocalDateTime;
import java.util.Arrays;

public class LocationMock {

    public static Location getLocationTest() {
        return Location.Builder.aLocation()
                .withId(1)
                .withName("Earth (C-137)")
                .withType("Planet")
                .withDimension("Dimension C-137")
                .withResidents(Arrays.asList("https://rickandmortyapi.com/api/character/38", "https://rickandmortyapi.com/api/character/45"))
                .withUrl("https://rickandmortyapi.com/api/location/1")
                .withCreated(LocalDateTime.now())
                .build();
    }
}
