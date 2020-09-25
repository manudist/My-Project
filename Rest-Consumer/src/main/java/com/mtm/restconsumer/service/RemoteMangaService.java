package com.mtm.restconsumer.service;

import com.mtm.event.EventManager;
import com.mtm.library.model.Manga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class RemoteMangaService implements MessageListener {
    private final Logger logger = LoggerFactory.getLogger(RemoteMangaService.class);
    private final WebClient client;
    private final EventManager eventManager;


    public RemoteMangaService(@Value("${remote.ws.url}") String url, EventManager eventManager) {
        client = WebClient.create(url);
        this.eventManager = eventManager;
    }

    @PostConstruct
    public void init() {
        eventManager.subscribeToEvent(myEvent -> logger.info("received event : " + myEvent.toString())
                , "update");
        eventManager.subscribeToEvent(myEvent -> logger.info("received event 2 : " + myEvent.toString())
                , "update");
        eventManager.subscribeToEvent(myEvent -> logger.info("received event 3 : " + myEvent.toString())
                , "update");
        eventManager.consumeEvent(myEvent -> logger.info("received event : " + myEvent.toString())
                , "update");
        eventManager.consumeEvent(myEvent -> logger.info("received event 2 : " + myEvent.toString())
                , "update");
        eventManager.consumeEvent(myEvent -> logger.info("received event 3 : " + myEvent.toString())
                , "update");
    }

    public static List<String> messageList = new ArrayList<String>();

    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());
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
