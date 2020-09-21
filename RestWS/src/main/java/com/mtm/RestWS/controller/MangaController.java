package com.mtm.RestWS.controller;
import com.mtm.RestWS.exception.ResourceNotFoundException;
import com.mtm.RestWS.service.MangaService;
import com.mtm.library.model.Manga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@RestController
public class MangaController {

    private final Logger logger = LoggerFactory.getLogger(MangaController.class);

    @Autowired
    private MangaService mangaService;

    @GetMapping("/manga")
    public List<Manga> getMangaList() {
        logger.info("getMangaList");
        return mangaService.getMangaList();
    }

    @PostMapping("/manga")
    public Manga createManga(@RequestBody Manga mangaToCreate){
        logger.info("createManga");
        return mangaService.saveManga(mangaToCreate);
    }

    @GetMapping("/manga/{id}")
    public Manga getMangaById (@PathVariable UUID id) throws Throwable {
        //Thread.sleep(10000);
        logger.info("getMangaById");
        return mangaService.getMangaById(id).orElseThrow((Supplier<Throwable>) ResourceNotFoundException::new);
    }

    @GetMapping("/mangascore/{score}")
    public Collection<Manga> getMangaListSufficientScore(@PathVariable double score) {
        logger.info("getMangaListSufficientScore");
        return mangaService.getMangaListSufficientScore(score);
    }


   /* @GetMapping("/manga/{title}")
    public Manga getMangaByTitle (@PathVariable String title) throws InterruptedException {
       //Thread.sleep(10000);
        logger.info("getMangaByTitle");
        return mangaService.getMangaFromTitle(title);
    }
    */
}
