package com.challenge.rickandmorty.infrastructure.adapter;

import com.challenge.rickandmorty.infrastructure.adapter.gateway.CharacterRequest;
import com.challenge.rickandmorty.application.exception.CharacterNotFoundException;
import com.challenge.rickandmorty.application.exception.HttpServerRickAndMortyException;
import com.challenge.rickandmorty.domain.model.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class CharacterRequestImp implements CharacterRequest {

    private final RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CharacterRequestImp.class);

    @Value("${endpoint.rickandmorty.character}")
    private String urlEndPoint;

    public CharacterRequestImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Character getCharacterById(Integer id) {
        logger.info("Endpoint URL Request : " + urlEndPoint);

        try {
            return restTemplate.getForObject(urlEndPoint, Character.class, String.valueOf(id));
        }catch(HttpClientErrorException e){
            logger.error("Request Error : " + e.getMessage());
            throw new CharacterNotFoundException();
        }catch (HttpServerErrorException e){
            logger.error("Request Error : " + e.getMessage());
            throw new HttpServerRickAndMortyException();
        }

    }
}
