package com.challenge.rickandmorty.infrastructure.adapter.gateway;

import com.challenge.rickandmorty.domain.model.Location;


public interface LocationRequest {

    public Location getLocationByUrl(String url);
}
