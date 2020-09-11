package com.mtm.RestWS.repository;

import com.mtm.library.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MangaRepository extends JpaRepository<Manga, UUID> {

    Manga findMangaByTitle(String title);
}
