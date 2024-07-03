package com.sparta.cw.libraryproject.model.repositories;

import com.sparta.cw.libraryproject.model.entities.AuthorDTO;
import com.sparta.cw.libraryproject.model.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookDTO, Integer> {

Optional<BookDTO> getAllByAuthor(AuthorDTO author);
}