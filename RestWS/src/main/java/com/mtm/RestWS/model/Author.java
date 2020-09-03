package com.mtm.RestWS.model;
import com.mtm.RestWS.controller.AuthorController;
import com.mtm.RestWS.controller.MangaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "author")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(mappedBy = "author")
    private List<Manga> mangaList;
    private String name;
    private String birthplace;
    private Instant birthdate;
    private String authorDescription;


    public Author(){

    }

    public Author(UUID id, String name, String birthplace, Instant birthdate, String authorDescription) {
        this.id = id;
        this.name = name;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.authorDescription = authorDescription;
    }


    public UUID getId() {
        MangaController.logger.info("getId");
        return id;
    }

    public List<Manga> getMangaList() {
        MangaController. logger.info("getMangaList");
        return mangaList;
    }

    public void setMangaList(List<Manga> mangaList) {
        MangaController.logger.info("setMangaList");
        this.mangaList = mangaList;
    }

    public void setId(UUID id) {
        MangaController. logger.info("setId");
        this.id = id;
    }

    public String getName() {
        MangaController. logger.info("getName");
        return name;
    }

    public void setName(String name) {
        MangaController. logger.info("setName");
        this.name = name;
    }

    public String getBirthplace() {
        MangaController.logger.info("getBirthplace");
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        MangaController.logger.info("setBirthplace");
        this.birthplace = birthplace;
    }

    public Instant getBirthdate() {
        MangaController. logger.info("getBirthdate");
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        MangaController.logger.info("setBirthdate");
        this.birthdate = birthdate;
    }


    public String getAuthorDescription() {
        MangaController.logger.info("getAuthorDescription");
        return authorDescription;
    }


    public void setAuthorDescription(String authorDescription) {
        MangaController.logger.info("setAuthorDescription");
        this.authorDescription = authorDescription;
    }
}
