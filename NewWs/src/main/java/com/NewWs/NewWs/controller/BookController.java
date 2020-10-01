package com.NewWs.NewWs.controller;

import com.Model.model.Book;
import com.NewWs.NewWs.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBookList() {
        logger.info("getBookList");
        return bookService.getBookList();
    }

    @PostMapping
    public Book createBook(@RequestBody Book bookToCreate){
        logger.info("createBook");
        return bookService.saveBook(bookToCreate);
    }

    @GetMapping("/{title}")
    public Optional<Book> getBookByTitle (@PathVariable String title){
        logger.info("getBookByName");
        return bookService.getBookFromTitle(title);
    }
}
