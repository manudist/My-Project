package com.mtm.RestWS.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MangaControllerTests {
    @Autowired
    private MangaController mangaController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(mangaController).isNotNull();
    }
}
