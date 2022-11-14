package com.challenge.rickandmorty.infrastructure.controller.exception;

import com.challenge.rickandmorty.application.exception.CharacterNotFoundException;
import com.challenge.rickandmorty.application.exception.HttpServerRickAndMortyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@RestControllerAdvice
public class ApplicationHandlerException {
    @ExceptionHandler(CharacterNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Map<String, String> handlerUserNotFoundException(){
        return Map.of("message","Character not found");
    }

    @ExceptionHandler(HttpServerRickAndMortyException.class)
    public ResponseEntity<Map<String,String>> handlerServerErrorException(){
        return ResponseEntity.internalServerError().body(Map.of("error","Server error"));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String,String>> MethodArgumentTypeMismatch(){
        return ResponseEntity.badRequest().body(Map.of("error","Hey! you must provide an id"));
    }
}
