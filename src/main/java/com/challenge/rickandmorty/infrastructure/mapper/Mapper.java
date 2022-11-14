package com.challenge.rickandmorty.infrastructure.mapper;

public interface Mapper<D, C, L> {
    public D fromModel(C character, L location);
}