package com.mtm.RestWS.controller;

import com.mtm.RestWS.exception.ResourceNotFoundException;
import com.mtm.library.model.Author;
import com.mtm.RestWS.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


@RestController
public class AuthorController {

    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public List<Author> getAuthorList() {
        logger.info("getAuthorList");
        return authorService.getAuthorList();
    }
    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author authorToCreate) {
        logger.info("createAuthor");
        return authorService.saveAuthor(authorToCreate);
    }
    @GetMapping("/author/{name}")
    public Author getAuthorByName (@PathVariable String name) throws Throwable {
        logger.info("getAuthorByName");
        //return authorService.getAuthorFromName(name).orElseThrow((Supplier<Throwable>) () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Autore non trovato"));
      return authorService.getAuthorFromName(name).orElseThrow((Supplier<Throwable>) ResourceNotFoundException::new);
    }
    @GetMapping("/authorplace/{birthplace}")
    public Collection<Author> getAuthorFromPlace(@PathVariable String birthplace) {
        logger.info("getAuthorFromPlace");
        return authorService.getAuthorFromPlace(birthplace);
    }
}

