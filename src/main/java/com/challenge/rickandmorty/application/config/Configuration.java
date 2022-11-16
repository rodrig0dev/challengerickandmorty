package com.challenge.rickandmorty.application.config;

import com.challenge.rickandmorty.infrastructure.adapter.CharacterRequestImp;
import com.challenge.rickandmorty.infrastructure.adapter.CharacterService;
import com.challenge.rickandmorty.infrastructure.adapter.LocationRequestImp;
import com.challenge.rickandmorty.infrastructure.adapter.gateway.CharacterRequest;
import com.challenge.rickandmorty.infrastructure.adapter.gateway.LocationRequest;
import com.challenge.rickandmorty.infrastructure.mapper.CharacterMapper;
import com.challenge.rickandmorty.application.usecase.GetCharacterByIdUseCase;
import com.challenge.rickandmorty.domain.gateway.CharacterGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CharacterRequest characterRequest(RestTemplate restTemplate){
        return new CharacterRequestImp(restTemplate);
    }

    @Bean
    public LocationRequest locationRequest(RestTemplate restTemplate){
        return new LocationRequestImp(restTemplate);
    }


    @Bean
    public CharacterMapper characterMapper(){
        return new CharacterMapper();
    }
    @Bean
    public GetCharacterByIdUseCase getCharacter(CharacterGateway characterGateway){
        return new GetCharacterByIdUseCase(characterGateway);
    }

    @Bean
    public CharacterGateway characterService(CharacterRequest characterReq, LocationRequest locationReq,
                                             CharacterMapper characterMapper){
        return new CharacterService(characterReq, locationReq, characterMapper);
    }

}
