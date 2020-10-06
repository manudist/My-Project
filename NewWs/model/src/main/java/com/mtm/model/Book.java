package com.mtm.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Book extends BaseEntity{
    @ManyToOne(optional = false)
    private Author author;
    @ManyToOne
    private Saga saga;
    private String title;

    public Book() {
    }

    public Book(UUID id, Calendar creationDate, Calendar modificationDate, Author author, Saga saga, String title) {
        super(id, creationDate, modificationDate);
        this.author = author;
        this.saga = saga;
        this.title = title;
    }

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
