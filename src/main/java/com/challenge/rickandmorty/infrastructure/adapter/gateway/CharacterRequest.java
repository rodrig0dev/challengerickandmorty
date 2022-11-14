package com.challenge.rickandmorty.infrastructure.adapter.gateway;

import com.challenge.rickandmorty.domain.model.Character;


public interface CharacterRequest {
    public Character getCharacterById(Integer id);
}
