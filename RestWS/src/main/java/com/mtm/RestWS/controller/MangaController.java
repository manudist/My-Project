package com.mtm.RestWS.controller;
import com.mtm.RestWS.model.Manga;
import com.mtm.RestWS.service.MangaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class MangaController {

    @Autowired
    private MangaService mangaService;
    public static Logger logger = LoggerFactory.getLogger(MangaController.class);


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
}
