package com.mtm.library.service;

import com.mtm.library.repository.ReaderRepository;
import com.mtm.model.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    private final Logger logger = LoggerFactory.getLogger(ReaderService.class);

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getReaderList() {
        return readerRepository.findAll();
    }

    public Optional<Reader> getReaderFromName(String name) {
        logger.info("getReaderFromName");
        return readerRepository.findReaderByName(name);
    }

    public Reader saveReader(Reader readerToBeSaved) {
        return readerRepository.save(readerToBeSaved);
    }
}
