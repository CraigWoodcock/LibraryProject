package com.sparta.cw.libraryproject.model.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "authors", schema = "library")
public class AuthorDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", nullable = false)
    private Integer id;

    @Size(max = 40)
    @Column(name = "full_name", length = 40)
    private String fullName;

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    @OneToMany(mappedBy = "author",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)

    private List<BookDTO> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}