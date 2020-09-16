package com.mtm.restconsumer.service;

import com.mtm.library.model.Manga;
import com.mtm.restconsumer.tools.EventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.UUID;


@Service
public class RemoteMangaService {
    private final Logger logger = LoggerFactory.getLogger(RemoteMangaService.class);
    private final WebClient client;
    private final EventManager eventManager;

    public RemoteMangaService(@Value("${remote.ws.url}") String url, EventManager eventManager) {
        client = WebClient.create(url);
        this.eventManager = eventManager;
    }
    @PostConstruct
    public void init(){
        eventManager.listenEvent(event -> {logger.info("received event : "+ event.toString());});
    }

    public Flux<Manga> getMangaList() {
        return client.get().uri("consumeMangaList").retrieve()
                .bodyToFlux(Manga.class);
    }

    public Mono<Manga> getMangaById(UUID id) {
        return client.get().uri("manga/{id}", id).retrieve()
                .bodyToMono(Manga.class);
    }


}
