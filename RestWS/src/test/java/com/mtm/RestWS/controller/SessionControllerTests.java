package com.mtm.RestWS.controller;

import com.mtm.library.model.Manga;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;


import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SessionControllerTests {
    @Autowired
    private SessionController sessionController;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;



    @Test
    public void contextLoads() throws Exception {
        assertThat(sessionController).isNotNull();
    }
    @Test
    public void testGet() throws Exception {
        assertThat(testRestTemplate.getForObject("http://localhost:"+port+"/session/find/1" , String.class)).isNotNull();
    }
}
