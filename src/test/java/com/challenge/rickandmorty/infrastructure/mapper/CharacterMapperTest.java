package com.challenge.rickandmorty.infrastructure.mapper;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.domain.model.Location;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterDTOMock;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterMock;
import com.challenge.rickandmorty.infrastructure.mocks.LocationMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



public class CharacterMapperTest {


    CharacterMapper mapper;
    Character character;
    Location location;


    @BeforeEach
    void setup(){
        mapper = new CharacterMapper();
        character = CharacterMock.getCharacterTest();
        location = LocationMock.getLocationTest();
    }

    @Test
    void shouldGetCharacterDTONotNull(){
        assertNotNull(mapper.fromModel(character, location));
    }

    @Test
    void shouldGetReturnNameDTO(){
        CharacterDTO characterDTO = mapper.fromModel(character, location);
        assertEquals(CharacterDTOMock.getCharacterDTO(character, location).getName(), characterDTO.getName());
    }

    @Test
    void shouldGetReturnEpisodeCountDTO(){
        CharacterDTO characterDTO = mapper.fromModel(character, location);
        assertEquals(CharacterDTOMock.getCharacterDTO(character, location).getEpisodeCount(), characterDTO.getEpisodeCount());
    }
}
