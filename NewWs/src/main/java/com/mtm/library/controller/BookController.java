package com.mtm.library.controller;

import com.mtm.messages.manager.MessageManager;
import com.mtm.model.Book;
import com.mtm.library.service.BookService;
import com.mtm.event.EventManager;
import com.mtm.event.model.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private EventManager eventManager;
    @Autowired
    private MessageManager messageManager;
    @Autowired
    private BookService bookService;

    @CrossOrigin
    @GetMapping
    public List<Book> getBookList() {
        logger.info("getBookList");
        return bookService.getBookList();
    }
    @CrossOrigin
    @PostMapping
    public Book createBook(@RequestBody Book bookToCreate){
        logger.info("createBook");
        return bookService.saveBook(bookToCreate);
    }

    @GetMapping("/{title}")
    public Optional<Book> getBookByTitle (@PathVariable String title){
        logger.info("getBookByTitle");
        return bookService.getBookFromTitle(title);
    }

    @GetMapping("/log")
   // @Scheduled(cron = "0 0/2 * * * *")
    public void logAllBooks (){
        eventManager.publishEvent(new MyEvent(this,"","book"));
        messageManager.publish("book","");
    }
}

