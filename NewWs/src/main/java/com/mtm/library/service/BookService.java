package com.mtm.library.service;

import antlr.debug.MessageListener;
import com.mtm.messages.manager.MessageManager;
import com.mtm.model.Book;
import com.mtm.library.repository.BookRepository;
import com.mtm.event.EventManager;
import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class BookService {
    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private EventManager eventManager;
    @Autowired
    private MessageManager messageManager;

    @PostConstruct
    public void init (){
        eventManager.subscribeToEvent(myEvent -> logger.info(getBookList().toString()),"book");
        messageManager.subscribe("book", message -> logger.info(getBookList().toString()));
    }

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

    public static List<String> messageList = new ArrayList<String>();

    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());
    }

}
