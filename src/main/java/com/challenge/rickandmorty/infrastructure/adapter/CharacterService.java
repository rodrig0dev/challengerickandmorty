package com.challenge.rickandmorty.infrastructure.adapter;

import com.challenge.rickandmorty.infrastructure.adapter.gateway.CharacterRequest;
import com.challenge.rickandmorty.infrastructure.adapter.gateway.LocationRequest;
import com.challenge.rickandmorty.infrastructure.mapper.CharacterMapper;
import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.domain.gateway.CharacterGateway;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.domain.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class CharacterService implements CharacterGateway {

    private final CharacterRequest characterReq;
    private final LocationRequest locationReq;
    private final CharacterMapper characterMap;
    private static final Logger logger = LoggerFactory.getLogger(CharacterService.class);

    public CharacterService(CharacterRequest characterReq, LocationRequest locationReq, CharacterMapper characterMap) {
        this.characterReq = characterReq;
        this.locationReq = locationReq;
        this.characterMap = characterMap;
    }


    @Override
    public CharacterDTO getCharacterById(Integer id) {
        Character character = characterReq.getCharacterById(id);
        logger.info("Character : " + character.toString());

        Location location = Location.Builder.aLocation()
                    .withResidents(new ArrayList<>())
                    .withDimension("")
                    .build();

        if(!character.getOrigin().getUrl().isEmpty()){
            location = locationReq.getLocationByUrl(character.getOrigin().getUrl());
            logger.info("Location : " +location.toString());

        }
        return characterMap.fromModel(character, location);
    }
}
