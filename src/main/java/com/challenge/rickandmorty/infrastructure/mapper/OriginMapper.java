package com.challenge.rickandmorty.infrastructure.mapper;

import com.challenge.rickandmorty.infrastructure.dto.OriginDTO;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.domain.model.Location;

public class OriginMapper implements Mapper<OriginDTO, Character, Location> {
    @Override
    public OriginDTO fromModel(Character character, Location location) {
        return OriginDTO.Builder.anOriginDTO()
                .withName(character.getOrigin().getName())
                .withUrl(character.getOrigin().getUrl())
                .withDimension(location.getDimension())
                .withResidents(location.getResidents())
                .build();
    }
}
