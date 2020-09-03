package com.mtm.RestWS.service;

import com.mtm.RestWS.controller.AuthorController;
import com.mtm.RestWS.model.Manga;
import com.mtm.RestWS.repository.MangaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangaService {

    private Logger logger = LoggerFactory.getLogger(MangaService.class);

    /*
    private final List<Manga> mangaList = new ArrayList<>();

    @PostConstruct
    private void init() {
        Manga newManga = new Manga("Test", "Manuel", "Il mio primo manga", Instant.now(), 8.5);
        mangaList.add(newManga);
    }

    public List<Manga> getMangaList() {
        return mangaList;
        }
     */
    @Autowired
    private MangaRepository mangaRepository;


    public List<Manga> getMangaList() {
        return mangaRepository.findAll();
    }

    public Manga getMangaFromTitle(String title) {
        logger.info("getMangaFromTitle");
        return mangaRepository.findMangaByTitle(title);
    }

    public Manga saveManga(Manga mangaToBeSaved) {
        return mangaRepository.save(mangaToBeSaved);
    }


}
