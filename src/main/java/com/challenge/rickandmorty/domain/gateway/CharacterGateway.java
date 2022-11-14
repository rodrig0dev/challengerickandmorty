package com.challenge.rickandmorty.domain.gateway;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;

public interface CharacterGateway {
    CharacterDTO getCharacterById(Integer id);
}
