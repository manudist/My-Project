package com.mtm.library.service;

import com.mtm.model.Author;
import com.mtm.library.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final Logger logger = LoggerFactory.getLogger(AuthorService.class);

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthorList() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorFromName(String name) {
        logger.info("getAuthorFromName");
        return authorRepository.findAuthorByName(name);
    }

    public Author saveAuthor(Author authorToBeSaved) {
        return authorRepository.save(authorToBeSaved);
    }
}