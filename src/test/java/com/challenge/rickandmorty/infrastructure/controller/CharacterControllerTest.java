package com.challenge.rickandmorty.infrastructure.controller;

import com.challenge.rickandmorty.infrastructure.mocks.CharacterDTOMock;
import com.challenge.rickandmorty.infrastructure.mocks.CharacterMock;
import com.challenge.rickandmorty.infrastructure.mocks.LocationMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterControllerTest.class)
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterController characterController;



    @Test
    void shouldFetchCharacterById() throws Exception {

        when(characterController.getCharacterById(1))
                .thenReturn(ResponseEntity.ok(CharacterDTOMock.getCharacterDTO(CharacterMock.getCharacterTest(), LocationMock.getLocationTest())));
        mockMvc.perform(get("/api/character/1"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Rick Sanchez"))
                .andExpect(jsonPath("$.status").value("Alive"))
                .andExpect(jsonPath("$.species").value("Human"))
                .andExpect(jsonPath("$.type").value(""))
                .andExpect(status().isOk());
    }

    @Test
    @SuppressWarnings("unchecked")
    void shouldReturn404WhenCharacterIdNotExist() throws Exception{
        Map<String,String> map = new HashMap<>();
        map.put("message","Character not found");

        when(characterController.getCharacterById(9999))
                .thenReturn(new ResponseEntity(map, HttpStatus.NOT_FOUND));

        mockMvc.perform(get("/api/character/9999"))
                    .andDo(print())
                    .andExpect(status().isNotFound());
        }

    @Test
    void shouldReturn400WhenBadRequest() throws Exception{
        mockMvc.perform(get("/api/character/-"))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }




}
