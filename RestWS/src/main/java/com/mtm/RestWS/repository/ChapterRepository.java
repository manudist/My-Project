package com.mtm.RestWS.repository;

import com.mtm.library.model.Chapter;
import com.mtm.library.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, UUID> {

    Chapter findChapterByName(String name);
    @Query("SELECT chapter FROM Chapter chapter WHERE chapter.chapterNumber = :chapterNumber")
    Collection<Chapter> getChapterFromNumber(@Param("chapterNumber") int chapterNumber);
}