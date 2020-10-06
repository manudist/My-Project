package com.mtm.library.controller;

import com.mtm.library.service.SagaService;
import com.mtm.model.Author;
import com.mtm.model.Book;
import com.mtm.model.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("saga")
public class SagaController {

    private final Logger logger = LoggerFactory.getLogger(SagaController.class);

    @Autowired
    private SagaService sagaService;

    @GetMapping
    public List<Saga> getSagaList() {
        logger.info("getSagaList");
        return sagaService.getSagaList();
    }

    @PostMapping
    public Saga createSaga(@RequestBody Saga sagaToCreate){
        logger.info("createSaga");
        return sagaService.saveSaga(sagaToCreate);
    }

    @GetMapping("/{name}")
    public Optional<Saga> getSagaByName (@PathVariable String name){
        logger.info("getSagaByName");
        return sagaService.getSagaFromName(name);
    }
    @PostMapping("/mock")
    public Saga createMockSaga(){
        Saga saga=new Saga();
        saga.setName("Test");
        Author author=new Author();
        author.setId( UUID.fromString("b3108913-c631-484b-a60a-9862fe28325c"));
        saga.setAuthor(author);
        return sagaService.saveSaga(saga);
    }

}
