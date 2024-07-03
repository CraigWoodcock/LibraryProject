package com.sparta.cw.libraryproject.controller;

import com.sparta.cw.libraryproject.Exceptions.AuthorNotFoundException;
import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import com.sparta.cw.libraryproject.model.entities.BookDTO;
import com.sparta.cw.libraryproject.model.repositories.AuthorRepository;
import com.sparta.cw.libraryproject.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<BookDTO> getBookById(@PathVariable Integer id){
        return bookRepository.findById(id);
    }

    @PostMapping("/books")
    public String addBook(@RequestBody BookDTO bookDTO) throws AuthorNotFoundException {
        Optional<AuthorDTO> author = authorRepository.findAuthorByFullName(bookDTO.getAuthor().getFullName());

        if (author.isEmpty()) {
            throw new AuthorNotFoundException(bookDTO.getAuthor().getFullName());
        } else {
            bookDTO.setAuthor(author.get());
            bookRepository.save(bookDTO);
            return "book has been saved";
        }
    }
    @DeleteMapping("/books/delete/{id}")
    public BookDTO deleteBook(@PathVariable Integer id){
        Optional<AuthorDTO> author = authorRepository.findAuthorByFullName(bookDTO.getAuthor().getFullName());

        if (author.isEmpty()){
            throw new AuthorNotFoundException(bookDTO.getAuthor().getFullName());
        }else {
            bookDTO.setAuthor(author.get());
            bookRepository.save(bookDTO);
            return "book has been saved";
        }
    }








}
