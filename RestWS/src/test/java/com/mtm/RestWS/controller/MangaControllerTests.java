package com.mtm.RestWS.controller;

import com.mtm.library.model.Manga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MangaControllerTests {
    @Autowired
    private MangaController mangaController;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mangaController).isNotNull();
    }
    @Test
    public void mangaNotFound(){
        assertThat(testRestTemplate.getForEntity("http://localhost:"+port+"/manga/b458b702-4832-4b31-84eb-327cf8e4d900", Manga.class).getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
