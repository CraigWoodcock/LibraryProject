package com.sparta.cw.libraryproject.controller;

import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import com.sparta.cw.libraryproject.model.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private final  AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    @GetMapping("/authors")
//    public List<AuthorDTO> getAllAuthors(){
//        return authorRepository.findAll();
//    }

    @GetMapping("/author/{id}")
    public Optional<AuthorDTO> getAuthorById(@PathVariable Integer id){
    return authorRepository.findById(id);
    }

    @GetMapping("/authors")
    public List<AuthorDTO> getAllAuthorsByName(@RequestParam(name = "name", required = false) String name){
       List<AuthorDTO> authors;

        if(name==null){
            authors = authorRepository.findAll();
        }else{
            authors = authorRepository.findAuthorsByFullName(name);
        }
        return authors;
    }

    @PatchMapping("/author/{id}") //updating a record using @PatchMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO newAuthor, @PathVariable Integer id){
        AuthorDTO author = null;
        if(authorRepository.findById(id).isPresent()){
            author = authorRepository.findById(id).get();
            author.setFullName(newAuthor.getFullName());
        }
        return authorRepository.save(author);
    }

    @PostMapping("/authors")
    public AuthorDTO createAuthor(@RequestBody AuthorDTO newAuthor){

        return authorRepository.save(newAuthor);
    }

    @DeleteMapping("/authors/delete/{id}")
    public AuthorDTO deleteAuthor(@PathVariable Integer id){
        AuthorDTO author = null;
        if(authorRepository.findById(id).isPresent()){
            author = authorRepository.findById(id).get();
            authorRepository.deleteById(id);

        }
        return author;
    }
}
