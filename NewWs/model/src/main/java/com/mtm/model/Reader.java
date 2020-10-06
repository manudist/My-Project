package com.mtm.model;

import javax.persistence.Entity;
import java.time.Instant;
import java.util.Calendar;
import java.util.UUID;

@Entity
public class Reader extends Person{

    public Reader() {
    }

    public Reader(UUID id, Calendar creationDate, Calendar modificationDate, String name, String description, String birthplace, Instant birthdate) {
        super(id, creationDate, modificationDate, name, description, birthplace, birthdate);
    }
}
