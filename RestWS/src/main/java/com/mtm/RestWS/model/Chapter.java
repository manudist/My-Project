package com.mtm.RestWS.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Manga manga;
    private int chapterNumber;
    private int rows;

    public Chapter(UUID id, String name, int chapterNumber, int rows) {
        this.id = id;
        this.name = name;
        this.chapterNumber = chapterNumber;
        this.rows = rows;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
