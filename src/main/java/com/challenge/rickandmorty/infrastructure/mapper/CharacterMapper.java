package com.challenge.rickandmorty.infrastructure.mapper;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.domain.model.Character;
import com.challenge.rickandmorty.domain.model.Location;
import org.springframework.stereotype.Component;


public class CharacterMapper implements Mapper<CharacterDTO, Character, Location> {
    @Override
    public CharacterDTO fromModel(Character character, Location location) {
        return CharacterDTO.Builder.aCharacterDTO()
                .withId(character.getId())
                .withName(character.getName())
                .withStatus(character.getStatus())
                .withSpecies(character.getSpecies())
                .withType(character.getType())
                .withEpisodeCount(character.getEpisode().size())
                .withOrigin(new OriginMapper().fromModel(character, location))
                .build();
    }

}
