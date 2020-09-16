package com.mtm.restconsumer.controller;

import com.mtm.library.model.Manga;
import com.mtm.restconsumer.service.RemoteMangaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
@RequestMapping("manga")
public class RemoteMangaController {

    private final Logger logger = LoggerFactory.getLogger(RemoteMangaController.class);


    private final RemoteMangaService remoteMangaService;

    public RemoteMangaController(RemoteMangaService remoteMangaService) {
        this.remoteMangaService = remoteMangaService;
    }

    @GetMapping("/remote")
    public Flux<Manga> getMangaList() {
        Flux<Manga> listManga = remoteMangaService.getMangaList();
        listManga.subscribe(manga -> logger.info("ricevuto manga : " + manga.getTitle()));
        logger.info("getMangaList");
        return listManga;

    }


    @GetMapping("/remote/{id}")
    public Mono<Manga> getMangaById(@PathVariable UUID id) {
        logger.info("getMangaById");
        Mono<Manga> mangaMono = remoteMangaService.getMangaById(id);
        mangaMono.subscribe(manga -> logger.info("ricevuto manga : " + manga.getTitle()));
        return mangaMono;
    }
}

