package com.challenge.rickandmorty.infrastructure.adapter;

import com.challenge.rickandmorty.infrastructure.adapter.gateway.LocationRequest;
import com.challenge.rickandmorty.domain.model.Location;
import org.springframework.web.client.RestTemplate;

public class LocationRequestImp implements LocationRequest {

    private final RestTemplate restTemplate;

    public LocationRequestImp(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }


    @Override
    public Location getLocationByUrl(String url) {
        return restTemplate.getForObject(url, Location.class);
    }
}
