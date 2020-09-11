package com.mtm.library.model;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "author")
public class Author extends BaseEntity{
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Manga> mangaList;
    private String name;
    private String birthplace;
    private Instant birthdate;
    private String authorDescription;


    public Author(){

    }

    public Author(UUID id, Calendar creationDate, Calendar modificationDate, List<Manga> mangaList, String name, String birthplace, Instant birthdate, String authorDescription) {
        super(id, creationDate, modificationDate);
        this.mangaList = mangaList;
        this.name = name;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.authorDescription = authorDescription;
    }

    public List<Manga> getMangaList() {
        //   VolumeController. logger.info("getMangaList");
        return mangaList;
    }

    public void setMangaList(List<Manga> mangaList) {
        //  VolumeController.logger.info("setMangaList");
        this.mangaList = mangaList;
    }



    public String getName() {
        // VolumeController. logger.info("getName");
        return name;
    }

    public void setName(String name) {
        //  VolumeController. logger.info("setName");
        this.name = name;
    }

    public String getBirthplace() {
        //   VolumeController.logger.info("getBirthplace");
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        //  VolumeController.logger.info("setBirthplace");
        this.birthplace = birthplace;
    }

    public Instant getBirthdate() {
        //  VolumeController. logger.info("getBirthdate");
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        //  VolumeController.logger.info("setBirthdate");
        this.birthdate = birthdate;
    }


    public String getAuthorDescription() {
        // VolumeController.logger.info("getAuthorDescription");
        return authorDescription;
    }


    public void setAuthorDescription(String authorDescription) {
        // VolumeController.logger.info("setAuthorDescription");
        this.authorDescription = authorDescription;
    }
}
