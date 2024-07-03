package com.sparta.cw.libraryproject;

import com.sparta.cw.libraryproject.controller.AuthorController;
import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import com.sparta.cw.libraryproject.model.repositories.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AuthorController.class)
public class MockingTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("Test Rest Response")
    void testRestResponse() throws Exception {
        AuthorDTO mockAuthor = new AuthorDTO();
        mockAuthor.setFullName("Mock Man!!");
        Mockito.when(authorRepository.findAll()).thenReturn(new ArrayList<>(List.of(mockAuthor)));
        mockMvc
                .perform(get("http://localhost:8080/authors"))
                .andExpect(status().is(200))
                .andExpect(content().contentType("application/json"))
                .andExpect(handler().methodName("getAllAuthorsByName"))
//                .andExpect(content().toString("Mock Man!!"))
                .andDo(print());
    }
}