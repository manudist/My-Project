package com.NewWs.NewWs.controller;

import com.Model.model.Author;
import com.NewWs.NewWs.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("author")
public class AuthorController {

    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthorList() {
        logger.info("getAuthorList");
        return authorService.getAuthorList();
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author authorToCreate) {
        logger.info("createAuthor");
        return authorService.saveAuthor(authorToCreate);
    }

    @GetMapping("/{name}")
    public Optional<Author> getAuthorByName(@PathVariable String name){
        logger.info("getAuthorByName");
        return authorService.getAuthorFromName(name);

    }
}
