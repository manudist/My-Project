package com.mtm.restconsumer.controller;

import com.mtm.event.EventManager;
import com.mtm.event.model.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(EventController.class);
    @Autowired
    private EventManager eventManager;


    @PostMapping("/{topic}")
    public void publishEvent(@PathVariable String topic) {
        MyEvent myEvent = new MyEvent(this, "Ciao", topic);
        eventManager.publishEvent(myEvent);
    }
}
