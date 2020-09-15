package com.mtm.restconsumer.controller;

import com.mtm.library.model.Manga;
import com.mtm.restconsumer.service.RemoteMangaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RestController
@RequestMapping("manga")
public class RemoteMangaController {

    private final Logger logger = LoggerFactory.getLogger(RemoteMangaController.class);

    @Autowired
    private RemoteMangaService remoteMangaService;


    @GetMapping("/remote/{id}")
    public Mono<Manga> getMangaById(@PathVariable UUID id) {
        logger.info("getMangaById");
        Mono<Manga> mangaMono = remoteMangaService.getMangaById(id);
        mangaMono.subscribe(manga -> logger.info("ricevuto manga : " + manga.getTitle()));
        return mangaMono;
    }
}

