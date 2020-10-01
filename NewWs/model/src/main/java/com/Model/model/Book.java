package com.Model.model;

import javax.persistence.ManyToOne;
import java.util.Calendar;
import java.util.UUID;

public class Book extends BaseEntity{
    @ManyToOne(optional = false)
    private Author author;
    private String title;

    public Book(UUID id, Calendar creationDate, Calendar modificationDate, Author author, String title) {
        super(id, creationDate, modificationDate);
        this.author = author;
        this.title = title;
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
