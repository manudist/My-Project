package com.mtm.restconsumer.controller;

import com.mtm.restconsumer.event.MyEvent;
import com.mtm.restconsumer.tools.EventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController  {

    private final Logger logger = LoggerFactory.getLogger(EventController.class);
    @Autowired
    private EventManager eventManager;
    private final ApplicationEventPublisher applicationEventPublisher;

    public EventController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @PostMapping("/myevent")
    public void publishMyEvent(final String message) {
        logger.info("publishing my event :");
        MyEvent myEvent = new MyEvent(this, message);
        applicationEventPublisher.publishEvent(myEvent);
    }

    @PostMapping
    public void publishEvent() {
        eventManager.publishEvent(new ApplicationEvent(EventController.this) {
            @Override
            public String toString() {
                return "my event";
            }
        });
    }
}
