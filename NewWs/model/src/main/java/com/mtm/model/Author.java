package com.mtm.model;

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
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Saga> sagaList;

    public Author() {
    }

    public Author(UUID id, Calendar creationDate, Calendar modificationDate, String name, String description, String birthplace, Instant birthdate, List<Book> bookList, List<Saga> sagaList) {
        super(id, creationDate, modificationDate, name, description, birthplace, birthdate);
        this.bookList = bookList;
        this.sagaList = sagaList;
    }

    public List<Saga> getSagaList() {
        return sagaList;
    }

    public void setSagaList(List<Saga> sagaList) {
        this.sagaList = sagaList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
