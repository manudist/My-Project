package com.Model.model;

import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.Calendar;
import java.util.UUID;

@MappedSuperclass
public abstract class Person extends BaseEntity {
    private String name;
    private String description;
    private String birthplace;
    private Instant birthdate;

    public Person(UUID id, Calendar creationDate, Calendar modificationDate,String name, String description, String birthplace, Instant birthdate) {
        super(id, creationDate, modificationDate);
        this.name = name;
        this.description = description;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Instant getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Instant birthdate) {
        this.birthdate = birthdate;
    }
}
