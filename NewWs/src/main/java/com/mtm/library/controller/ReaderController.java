package com.mtm.library.controller;

import com.mtm.library.service.ReaderService;
import com.mtm.model.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reader")
public class ReaderController {
    private final Logger logger = LoggerFactory.getLogger(ReaderController.class);

    @Autowired
    private ReaderService readerService;
    @CrossOrigin
    @GetMapping
    public List<Reader> getReaderList() {
        logger.info("getReaderList");
        return readerService.getReaderList();
    }
    @CrossOrigin
    @PostMapping
    public Reader createReader(@RequestBody Reader readerToCreate) {
        logger.info("createReader");
        return readerService.saveReader(readerToCreate);
    }

    @GetMapping("/{name}")
    public Optional<Reader> getReaderByName(@PathVariable String name) {
        logger.info("getReaderByName");
        return readerService.getReaderFromName(name);

    }
}
