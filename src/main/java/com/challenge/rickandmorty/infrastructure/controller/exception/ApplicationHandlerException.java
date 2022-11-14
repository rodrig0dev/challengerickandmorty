package com.challenge.rickandmorty.infrastructure.controller.exception;

import com.challenge.rickandmorty.application.exception.CharacterNotFoundException;
import com.challenge.rickandmorty.application.exception.HttpServerRickAndMortyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationHandlerException {
    @ExceptionHandler(value = CharacterNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlerUserNotFoundException(){

        Map<String,String> map = new HashMap<>();
        map.put("message","Character not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpServerRickAndMortyException.class)
    public ResponseEntity<Map<String,String>> handlerServerErrorException(){

        Map<String,String> map = new HashMap<>();
        map.put("error","Server error");
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String,String>> MethodArgumentTypeMismatch(){

        Map<String,String> map = new HashMap<>();
        map.put("error","Hey! you must provide an id");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
