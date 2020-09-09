package com.mtm.RestWS.tools;
import com.mtm.RestWS.model.Author;
import com.mtm.RestWS.model.Manga;
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

    public Flux<Author> getAsyncAuthor(String name) {
        return webClient.get().uri("author/" + name).retrieve().bodyToFlux(Author.class);
    }
}
