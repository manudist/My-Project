package com.mtm.RestWS.service;

import com.mtm.RestWS.controller.AuthorController;
import com.mtm.library.model.Author;
import com.mtm.RestWS.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAuthorList() {
        return authorRepository.findAll();
    }

    public Author getAuthorFromName(String name) {
        logger.info("getAuthorFromName");
        return authorRepository.findAuthorByName(name);
    }

    public Author saveAuthor(Author authorToBeSaved) {
        return authorRepository.save(authorToBeSaved);
    }
}

