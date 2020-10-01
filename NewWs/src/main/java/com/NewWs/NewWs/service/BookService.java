package com.NewWs.NewWs.service;

import com.Model.model.Book;
import com.NewWs.NewWs.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getBookList() {
        return bookRepository.findAll();
    }


    public Optional<Book> getBookFromTitle(String title) {
        logger.info("getBookFromName");
        return bookRepository.findBookByTitle(title);
    }

    public Book saveBook(Book bookToBeSaved) {
        return bookRepository.save(bookToBeSaved);
    }



}
