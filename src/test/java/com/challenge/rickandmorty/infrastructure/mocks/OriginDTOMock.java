package com.challenge.rickandmorty.infrastructure.mocks;

import com.challenge.rickandmorty.infrastructure.dto.OriginDTO;
import com.challenge.rickandmorty.domain.model.Location;
import com.challenge.rickandmorty.domain.model.Character;

public class OriginDTOMock {

    public static OriginDTO getOriginDTO(Character character, Location location){
        return OriginDTO.Builder.anOriginDTO()
                .withName(character.getOrigin().getName())
                .withUrl(character.getOrigin().getUrl())
                .withDimension(location.getDimension())
                .withResidents(location.getResidents()).build();
    }
}
