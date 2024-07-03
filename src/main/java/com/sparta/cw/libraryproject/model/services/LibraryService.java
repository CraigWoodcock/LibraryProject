package com.sparta.cw.libraryproject.model.services;

import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import com.sparta.cw.libraryproject.model.entities.BookDTO;
import com.sparta.cw.libraryproject.model.repositories.AuthorRepository;
import com.sparta.cw.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

}

