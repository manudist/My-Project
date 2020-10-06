package com.mtm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Entity
public class Saga extends BaseEntity{
    private String name;
    //todo verificare come rendere non opzionale
    @OneToMany(mappedBy = "saga")
    @JsonIgnore
    private List<Book> bookList;
    @ManyToOne(optional = false)
    private Author author;

    public Saga(UUID id, Calendar creationDate, Calendar modificationDate, String name, List<Book> bookList, Author author) {
        super(id, creationDate, modificationDate);
        this.name = name;
        this.bookList = bookList;
        this.author = author;
    }


    public Saga() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
