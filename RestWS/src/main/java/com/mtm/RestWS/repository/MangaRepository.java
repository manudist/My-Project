package com.mtm.RestWS.repository;

import com.mtm.library.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface MangaRepository extends JpaRepository<Manga, UUID> {

    Manga findMangaByTitle(String title);
    @Query("SELECT manga FROM Manga manga WHERE manga.score> :score")
    Collection<Manga> getSufficientScoreManga(@Param("score") double score);

}
