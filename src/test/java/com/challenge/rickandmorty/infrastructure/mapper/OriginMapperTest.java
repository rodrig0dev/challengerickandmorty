package com.challenge.rickandmorty.infrastructure.mapper;

import com.challenge.rickandmorty.infrastructure.dto.OriginDTO;
import com.challenge.rickandmorty.domain.model.Location;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterMock;
import com.challenge.rickandmorty.infrastructure.mocks.LocationMock;
import com.challenge.rickandmorty.infrastructure.mocks.OriginDTOMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OriginMapperTest {

    OriginMapper mapper;
    Character character;
    Location location;


    @BeforeEach
    void setup(){
        mapper = new OriginMapper();
        character = CharacterMock.getCharacterTest();
        location = LocationMock.getLocationTest();
    }

    @Test
    void shouldGetOriginDTONotNull(){
        assertNotNull(mapper.fromModel(character, location));
    }

    @Test
    void shouldGetReturnOriginNameDTO(){
        OriginDTO originDTO = mapper.fromModel(character, location);
        assertEquals(OriginDTOMock.getOriginDTO(character, location).getName(), originDTO.getName());
    }

    @Test
    void shouldGetReturnSizeListResidentDTO(){
        OriginDTO originDTO = mapper.fromModel(character, location);
        assertEquals(OriginDTOMock.getOriginDTO(character, location).getResidents().size(), originDTO.getResidents().size());
    }
}
