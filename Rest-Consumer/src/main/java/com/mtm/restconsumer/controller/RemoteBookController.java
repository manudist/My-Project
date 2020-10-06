package com.mtm.restconsumer.controller;

import com.mtm.model.Book;
import com.mtm.restconsumer.service.RemoteBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("book")
public class RemoteBookController {
    private final Logger logger = LoggerFactory.getLogger(RemoteBookController.class);


    private final RemoteBookService remoteBookService;

    public RemoteBookController(RemoteBookService remoteBookService) {
        this.remoteBookService = remoteBookService;
    }

    @GetMapping("/remote")
    public Flux<Book> getBookList() {
        Flux<Book> listBook = remoteBookService.getBookList();
        listBook.subscribe(book -> logger.info("ricevuto libro : " + book.getTitle()));
        logger.info("getBookList");
        return listBook;

    }


    @GetMapping("/remote/{title}")
    public Mono<Book> getBookByTitle(@PathVariable String title) {
        logger.info("getBookByTitle");
        Mono<Book> bookMono = remoteBookService.getBookByTitle(title);
        bookMono.subscribe(book -> logger.info("ricevuto libro : " + book.getTitle()));
        return bookMono;
    }
}
