package com.mtm.RestWS.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.function.Consumer;

@RestController
@RequestMapping("session/")
public class SessionController {
    private final Logger logger= LoggerFactory.getLogger(SessionController.class);


    @PostMapping("add/{key}")
    public void addToSession(@PathVariable String key, @RequestBody String body, HttpSession session){
        session.setAttribute(key,body);
    }
    @GetMapping("find/{key}")
    public void FindOnSession(@PathVariable String key, HttpSession session){
       logger.info(session.getAttribute(key).toString());
    }
    @GetMapping("info")
    public void sessionInfo(HttpSession session){
        session.getAttributeNames().asIterator().forEachRemaining(logger::info);
        logger.info(session.getId());
        logger.info(session.getServletContext().toString());
    }
}
