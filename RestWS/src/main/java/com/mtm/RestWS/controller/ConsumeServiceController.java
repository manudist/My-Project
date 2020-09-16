package com.mtm.RestWS.controller;

import com.mtm.RestWS.tools.AsyncHttpTester;
import com.mtm.library.model.Author;
import com.mtm.library.model.Manga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

@RestController
public class ConsumeServiceController {

    private final Logger logger = LoggerFactory.getLogger(ConsumeServiceController.class);

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private AsyncHttpTester async;

    @GetMapping("/consume")
    // @Scheduled(cron = "0 0/1 * * * *")
    public Manga consume() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        Manga manga = restTemplate.getForObject("http://localhost:8080/manga/Test", Manga.class);
        logger.info("Recuperato manga: " + manga.getTitle());
        return manga;
    }

    @GetMapping("/consumeMangaList")
    public Flux<Manga> consumeMangaList() {
        return async.getAsyncMangaList();
    }

    @GetMapping("/consumeAuthor")
    //@Scheduled(cron = "0 0/2 * * * *")
    public Author consumeAuthor() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        Author author = restTemplate.getForObject("http://localhost:8080/author/Test", Author.class);
        logger.info("Recuperato autore: " + author.getName());
        return author;
    }

    @GetMapping("/consumeWebClient")
    public Flux<Manga> consumeWebClient() {
        return async.getAsyncManga("Test");
    }

    @GetMapping("/consumeAuthorWebClient")
    public Flux<Author> consumeAuthorWebClient() {
        return async.getAsyncAuthor("Test");
    }
}
