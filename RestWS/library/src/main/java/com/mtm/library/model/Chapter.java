package com.mtm.library.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Chapter extends BaseEntity {

    private String name;
    @ManyToOne(optional = false)
    private Manga manga;
    @ManyToOne()
    private Volume volume;
    private int chapterNumber;
    private int rows;

    public Chapter(UUID id, Calendar creationDate, Calendar modificationDate, String name, Manga manga, Volume volume, int chapterNumber, int rows) {
        super(id, creationDate, modificationDate);
        this.name = name;
        this.manga = manga;
        this.volume = volume;
        this.chapterNumber = chapterNumber;
        this.rows = rows;
    }

    public Chapter() {
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public Manga getManga() {
        return manga;
    }

    public void setManga(Manga manga) {
        this.manga = manga;
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
