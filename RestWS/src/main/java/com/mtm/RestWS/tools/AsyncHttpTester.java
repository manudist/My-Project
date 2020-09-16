package com.mtm.RestWS.tools;
import com.mtm.library.model.Author;
import com.mtm.library.model.Manga;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class AsyncHttpTester {

    private final WebClient webClient;

    public AsyncHttpTester() {
        this.webClient = WebClient.create("http://localhost:8080/");
    }

    public Flux<Manga> getAsyncManga(String title) {
        return webClient.get().uri("manga/" + title).retrieve().bodyToFlux(Manga.class);
    }

    public Flux<Manga> getAsyncMangaList () {
        return webClient.get().uri("manga").retrieve().bodyToFlux(Manga.class);
    }


    public Flux<Author> getAsyncAuthor(String name) {
        return webClient.get().uri("author/" + name).retrieve().bodyToFlux(Author.class);
    }
}
