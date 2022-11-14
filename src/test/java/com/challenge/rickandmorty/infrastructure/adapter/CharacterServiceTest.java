package com.challenge.rickandmorty.infrastructure.adapter;

import com.challenge.rickandmorty.infrastructure.adapter.gateway.CharacterRequest;
import com.challenge.rickandmorty.infrastructure.adapter.gateway.LocationRequest;
import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.infrastructure.mapper.CharacterMapper;
import com.challenge.rickandmorty.domain.model.Location;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterDTOMock;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterMock;
import com.challenge.rickandmorty.infrastructure.mocks.LocationMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    private CharacterRequest characterReq;
    @Mock
    private LocationRequest locationReq;
    @Mock
    private CharacterMapper characterMap;

    @InjectMocks
    private CharacterService characterService;

    private CharacterDTO characterDTO;
    private Character character;
    private Location location;

    @BeforeEach
    void setup(){
        characterService = new CharacterService(characterReq, locationReq, characterMap);
        characterDTO = CharacterDTOMock.getCharacterDTO(CharacterMock.getCharacterTest(), LocationMock.getLocationTest());
        character = CharacterMock.getCharacterTest();
        location = LocationMock.getLocationTest();
    }

    @Test
    void shouldGetCharacterIsAlive(){

        final Integer characterId = 1;
        when(characterReq.getCharacterById(characterId))
                .thenReturn(character);
        when(locationReq.getLocationByUrl(character.getOrigin().getUrl()))
                .thenReturn(location);
        when(characterMap.fromModel(character, location))
                .thenReturn(characterDTO);
        when(characterService.getCharacterById(characterId))
                .thenReturn(characterDTO);

        assertTrue("Alive".equals(characterService.getCharacterById(1).getStatus()));
    }

}
