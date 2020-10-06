package com.mtm.library.service;

import com.mtm.library.repository.SagaRepository;
import com.mtm.model.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SagaService {
    private final Logger logger = LoggerFactory.getLogger(SagaService.class);

    @Autowired
    private SagaRepository sagaRepository;

    public List<Saga> getSagaList() {
        return sagaRepository.findAll();
    }

    public Optional<Saga> getSagaFromName(String name) {
        logger.info("getSagaFromName");
        return sagaRepository.findSagaByName(name);
    }

    public Saga saveSaga(Saga sagaToBeSaved) {
        return sagaRepository.save(sagaToBeSaved);
    }
}
