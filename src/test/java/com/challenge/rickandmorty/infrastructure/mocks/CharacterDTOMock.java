package com.challenge.rickandmorty.infrastructure.mocks;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.domain.model.Location;
import com.challenge.rickandmorty.domain.model.Character;
import static com.challenge.rickandmorty.infrastructure.mocks.OriginDTOMock.getOriginDTO;

public class CharacterDTOMock {

    public static CharacterDTO getCharacterDTO(Character character, Location location){
        return com.challenge.rickandmorty.infrastructure.dto.CharacterDTO.Builder.aCharacterDTO()
                .withId(character.getId())
                .withName(character.getName())
                .withStatus(character.getStatus())
                .withSpecies(character.getSpecies())
                .withType(character.getType())
                .withEpisodeCount(character.getEpisode().size())
                .withOrigin(getOriginDTO(character, location))
                .build();
    }
}
