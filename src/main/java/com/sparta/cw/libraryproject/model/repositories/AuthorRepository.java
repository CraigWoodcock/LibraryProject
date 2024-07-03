package com.sparta.cw.libraryproject.model.repositories;

import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import com.sparta.cw.libraryproject.model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDTO, Integer> {


//    List<AuthorDTO> findByFirstName(String name);

    List<AuthorDTO> findAuthorsByFullName(String name);


    Optional<AuthorDTO> findAuthorByFullName(String fullName);

}