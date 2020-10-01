package com.Model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Entity
public class Author extends Person {
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> bookList;

    public Author(UUID id, Calendar creationDate, Calendar modificationDate, String name, String description, String birthplace, Instant birthdate, List<Book> bookList) {
        super(id, creationDate, modificationDate, name, description, birthplace, birthdate);
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
