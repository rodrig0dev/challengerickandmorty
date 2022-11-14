package com.challenge.rickandmorty.infrastructure.mocks;


import com.challenge.rickandmorty.domain.model.CharacterLocation;
import com.challenge.rickandmorty.domain.model.CharacterOrigin;
import com.challenge.rickandmorty.domain.model.Character;

import java.time.LocalDateTime;
import java.util.Arrays;

public class CharacterMock {

    public static Character getCharacterTest() {

        return Character.Builder.aCharacter()
                .withId(1)
                .withName("Rick Sanchez")
                .withStatus("Alive")
                .withSpecies("Human")
                .withType("")
                .withGender("Male")
                .withOrigin(CharacterOrigin.Builder.aCharacterOrigin().withName("Earth").withUrl("https://rickandmortyapi.com/api/location/1").build())
                .withLocation(CharacterLocation.Builder.aCharacterLocation().withName("Citadel of Ricks").withUrl("https://rickandmortyapi.com/api/location/3").build())
                .withImage("https://rickandmortyapi.com/api/character/avatar/1.jpeg")
                .withEpisode(Arrays.asList("https://rickandmortyapi.com/api/episode/1", "https://rickandmortyapi.com/api/episode/2"))
                .withUrl("https://rickandmortyapi.com/api/character/1")
                .withCreated(LocalDateTime.now()).build();
    }







}
