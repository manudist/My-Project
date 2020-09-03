package com.mtm.RestWS.model;
import com.mtm.RestWS.controller.MangaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "manga")
public class Manga{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Author author;
    @OneToMany(mappedBy = "manga")
    private List<Chapter> chapterList;
    private String description;
    private Instant publicationDate;
    private Double score;


    public Manga(String title, Author author, String description, Instant publicationDate, Double score) {
        this.title = title;
        this.author = author;
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
        MangaController.logger.info("getAuthor");
        return author;
    }

    public void setAuthor(Author author) {
        MangaController.logger.info("setAuthor");
        this.author = author;
    }

    public UUID getId() {
        MangaController.logger.info("getId");
        return id;
    }

    public void setId(UUID id) {
        MangaController.logger.info("setId");
        this.id = id;
    }

    public String getTitle() {
        MangaController.logger.info("getTitle");
        return title;
    }

    public void setTitle(String title) {
        MangaController.logger.info("setTitle");
        this.title = title;
    }

    public String getDescription() {
        MangaController.logger.info("getDescription");
        return description;
    }

    public void setDescription(String description) {
        MangaController.logger.info("setDescription");
        this.description = description;
    }

    public Instant getPublicationDate() {
        MangaController.logger.info("getPublicationDate");
        return publicationDate;
    }

    public void setPublicationDate(Instant publicationDate) {
        MangaController.logger.info("setPublicationDate");
        this.publicationDate= publicationDate;
    }

    public Double getScore() {
        MangaController. logger.info("getScore");
        return score;
    }

    public void setScore(Double score) {
        MangaController.logger.info("setScore");
        this.score = score;
    }
}
