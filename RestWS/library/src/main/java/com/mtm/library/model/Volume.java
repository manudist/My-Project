package com.mtm.library.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Entity
public class Volume extends BaseEntity {

    private int volumeNumber;
    private String index;
    @OneToMany(mappedBy = "volume")
    private List<Chapter> chapterList;
    public Volume(UUID id, Calendar creationDate, Calendar modificationDate, int volumeNumber, String index, List<Chapter> chapterList) {
        super(id, creationDate, modificationDate);
        this.volumeNumber = volumeNumber;
        this.index = index;
        this.chapterList = chapterList;
    }

    public Volume() {
    }



    public int getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(int volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }
}
