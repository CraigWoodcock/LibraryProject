package com.sparta.cw.libraryproject;

import com.sparta.cw.libraryproject.controller.AuthorController;
import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LibraryRestTests {

    private WebTestClient testClient;

    @Autowired
    private AuthorController authorController;

    @BeforeEach
    void setup(){
        testClient = WebTestClient
                    .bindToController(authorController)
                    .build();
    }

    @Test
    @DisplayName("Check that the status code is 200")
    void checkThatTheStatusCodeIs200(){
        //fluent api - almost English phrases to say what you want
        //DSL - Domain specific language

        testClient
                .get()
                .uri("http://localhost:8080/authors")
                .exchange()
                .expectStatus()
                .isEqualTo(200);
    }

    @Test
    @DisplayName("Check that the first Author is Craig")
    void checkThatTheFirstAuthorIsCraig(){
        testClient
                .get()
                .uri("http://localhost:8080/author/1")
                .exchange()
                .expectBody(AuthorDTO.class)
                .value(author -> assertEquals("Craig Woodcock",  author.getFullName()));
    }
}
