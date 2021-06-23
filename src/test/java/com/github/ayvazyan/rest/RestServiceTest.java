package com.github.ayvazyan.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersonService personService;

    @Test
    void registrationWorksThroughAllLayers() throws Exception {
        //Given
        Person person = new Person();
        person.setName("testName");
        //When
        mockMvc.perform(post("/api/store")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isOk());
        //Then
        assertThat(personService.getStoredPerson().getName()).isEqualTo(person.getName());
    }

}