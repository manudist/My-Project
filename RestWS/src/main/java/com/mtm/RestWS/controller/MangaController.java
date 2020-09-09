package com.mtm.RestWS.controller;
import com.mtm.RestWS.model.Manga;
import com.mtm.RestWS.service.MangaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class MangaController {

    @Autowired
    private MangaService mangaService;
    private final Logger logger = LoggerFactory.getLogger(MangaController.class);


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
    @GetMapping("/manga/{title}")
    public Manga getMangaByTitle (@PathVariable String title) throws InterruptedException {
       Thread.sleep(10000);
        logger.info("getMangaByTitle");
        return mangaService.getMangaFromTitle(title);
    }
}
