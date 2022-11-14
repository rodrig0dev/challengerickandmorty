package com.challenge.rickandmorty.application.usecase;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.domain.gateway.CharacterGateway;

public class GetCharacterByIdUseCase {

    private final CharacterGateway domainGateway;

    public GetCharacterByIdUseCase(CharacterGateway domainGateway) {
        this.domainGateway = domainGateway;
    }


    public CharacterDTO getCharacterById(Integer id){
        return domainGateway.getCharacterById(id);
    }
}
