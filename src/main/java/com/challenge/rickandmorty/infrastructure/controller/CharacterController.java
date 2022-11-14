package com.challenge.rickandmorty.infrastructure.controller;

import com.challenge.rickandmorty.infrastructure.dto.CharacterDTO;
import com.challenge.rickandmorty.application.usecase.GetCharacterByIdUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class CharacterController {

    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);
    private final GetCharacterByIdUseCase characterByIdUseCase;

    public CharacterController(GetCharacterByIdUseCase characterByIdUseCase) {
            this.characterByIdUseCase = characterByIdUseCase;
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable("id") Integer id){

        logger.info("Initialize Challenge Rick and Morty");
        return ResponseEntity.ok(characterByIdUseCase.getCharacterById(id));
    }
}
