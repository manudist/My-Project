package com.mtm.restconsumer.service;

import com.mtm.event.EventManager;
import com.mtm.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Service
public class RemoteBookService {
    private final Logger logger = LoggerFactory.getLogger(RemoteBookService.class);
    private final WebClient client;
    private final EventManager eventManager;


    public RemoteBookService(@Value("${remote.ws.url}") String url, EventManager eventManager) {
        client = WebClient.create(url);
        this.eventManager = eventManager;
    }

    @PostConstruct
    public void init() {
        eventManager.subscribeToEvent(myEvent -> logger.info("received event : " + myEvent.toString())
                , "update");
        eventManager.subscribeToEvent(myEvent -> logger.info("received event : " + myEvent.toString())
                , "update");
        eventManager.consumeEvent(myEvent -> logger.info("received event : " + myEvent.toString())
                , "update");
        eventManager.consumeEvent(myEvent -> logger.info("received event 2 : " + myEvent.toString())
                , "update");
    }

    public Flux<Book> getBookList() {
        return client.get().uri("consumeBookList").retrieve()
                .bodyToFlux(Book.class);
    }

    public Mono<Book> getBookByTitle(String title) {
        return client.get().uri("book/{title}", title).retrieve()
                .bodyToMono(Book.class);
    }
}
