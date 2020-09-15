package com.mtm.restconsumer.service;
import com.mtm.library.model.Manga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Service
public class RemoteMangaService {
    private final Logger logger = LoggerFactory.getLogger(RemoteMangaService.class);
    private final WebClient client;

    public RemoteMangaService(@Value( "${remote.ws.url}" ) String url) {
        client=WebClient.create(url);
    }

    public Mono<Manga> getMangaById(UUID id) {
        return client.get().uri( "manga/{id}", id).retrieve()
                    .bodyToMono(Manga.class);
    }
}
