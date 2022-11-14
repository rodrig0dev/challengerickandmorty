package com.challenge.rickandmorty.application.usecase;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.domain.gateway.CharacterGateway;
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
public class GetCharacterByIdUseCaseTest {

    @Mock
    private CharacterGateway domainGateway;

    @InjectMocks
    private GetCharacterByIdUseCase getCharacterByIdUseCase;

    private CharacterDTO characterDTO;

    @BeforeEach
    void setup() {
        getCharacterByIdUseCase = new GetCharacterByIdUseCase(domainGateway);
        characterDTO = CharacterDTOMock.getCharacterDTO(CharacterMock.getCharacterTest(), LocationMock.getLocationTest());
    }


    @Test
    void shouldGetCharacterDTOisStatusAlive(){

        final Integer characterId = 1;
        when(domainGateway.getCharacterById(characterId)).thenReturn(characterDTO);
        when(getCharacterByIdUseCase.getCharacterById(characterId)).thenReturn(characterDTO);


        assertTrue("Alive".equals(getCharacterByIdUseCase.getCharacterById(1).getStatus()));
    }


}
