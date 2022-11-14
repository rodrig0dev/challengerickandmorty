package com.challenge.rickandmorty.infrastructure.adapter;

import com.challenge.rickandmorty.infrastructure.adapter.gateway.CharacterRequest;
import com.challenge.rickandmorty.application.exception.CharacterNotFoundException;
import com.challenge.rickandmorty.application.exception.HttpServerRickAndMortyException;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CharacterRequestImpTest {

    @Mock
    CharacterRequest characterRequest;


    @Test
    public void shouldGetCharacterSpeciesIsHuman(){
        final Integer characterId = 1;
        when(characterRequest.getCharacterById(characterId))
                .thenReturn(CharacterMock.getCharacterTest());
        Character characterMock = characterRequest.getCharacterById(characterId);
        assertEquals("Human",characterMock.getSpecies());
    }

    @Test
    public void shouldGetCharacterLocationNameIsCitadel(){
        final Integer characterId = 1;
        when(characterRequest.getCharacterById(characterId))
                .thenReturn(CharacterMock.getCharacterTest());
        Character characterMock = characterRequest.getCharacterById(characterId);
        assertEquals("Citadel of Ricks",characterMock.getLocation().getName());
    }

    @Test
    public void shouldReturnErrorCharacterNotFound(){
        final Integer characterIdNotFound = 999;
        when(characterRequest.getCharacterById(characterIdNotFound))
                .thenThrow(CharacterNotFoundException.class);
        RuntimeException exception = assertThrows(CharacterNotFoundException.class, () -> characterRequest.getCharacterById(characterIdNotFound));
        assertEquals(CharacterNotFoundException.class, exception.getClass());
    }

    @Test
    public void shouldReturnErrorServerApi(){
        final Integer characterId = 1;
        when(characterRequest.getCharacterById(characterId))
                .thenThrow(HttpServerRickAndMortyException.class);
        RuntimeException exception = assertThrows(HttpServerRickAndMortyException.class, () -> characterRequest.getCharacterById(characterId));
        assertEquals(HttpServerRickAndMortyException.class, exception.getClass());
    }
}
