package com.mtm.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "manga")
public class Manga extends BaseEntity implements Serializable {

    private String title;
    @ManyToOne(/*cascade = {CascadeType.PERSIST,CascadeType.MERGE},*/ optional = false)
    private Author author;
    @JsonIgnore
    @OneToMany(mappedBy = "manga")
    private List<Chapter> chapterList;
    private String description;
    private Instant publicationDate;
    private Double score;


    public Manga(UUID id, Calendar creationDate, Calendar modificationDate, String title, Author author, List<Chapter> chapterList, String description, Instant publicationDate, Double score) {
        super(id, creationDate, modificationDate);
        this.title = title;
        this.author = author;
        this.chapterList = chapterList;
        this.description = description;
        this.publicationDate = publicationDate;
        this.score = score;
    }

    public Manga() {
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Author getAuthor() {
        //VolumeController.logger.info("getAuthor");
        return author;
    }

    public void setAuthor(Author author) {
        // VolumeController.logger.info("setAuthor");
        this.author = author;
    }


    public String getTitle() {
        // VolumeController.logger.info("getTitle");
        return title;
    }

    public void setTitle(String title) {
        // VolumeController.logger.info("setTitle");
        this.title = title;
    }

    public String getDescription() {
        // VolumeController.logger.info("getDescription");
        return description;
    }

    public void setDescription(String description) {
        // VolumeController.logger.info("setDescription");
        this.description = description;
    }

    public Instant getPublicationDate() {
        // VolumeController.logger.info("getPublicationDate");
        return publicationDate;
    }

    public void setPublicationDate(Instant publicationDate) {
        //  VolumeController.logger.info("setPublicationDate");
        this.publicationDate = publicationDate;
    }

    public Double getScore() {
        //  VolumeController. logger.info("getScore");
        return score;
    }

    public void setScore(Double score) {
        // VolumeController.logger.info("setScore");
        this.score = score;
    }
}
