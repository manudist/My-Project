package com.mtm.restconsumer.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


@Component
public class EventManager implements ApplicationListener<ApplicationEvent> {
    private final Logger logger = LoggerFactory.getLogger(EventManager.class);
    private final ApplicationEventPublisher applicationEventPublisher;
    private final List<Consumer<ApplicationEvent>> consumers;


    public EventManager(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.consumers = new ArrayList<>();
    }

    @Override
    public void onApplicationEvent(ApplicationEvent myEvent) {
        consumers.forEach(eventConsumer -> {
            eventConsumer.accept(myEvent);
        });
    }

    public void listenEvent(Consumer<ApplicationEvent> eventConsumer) {
        consumers.add(eventConsumer);
    }

    public void publishEvent(ApplicationEvent event) {

        logger.info("sending event : " + event.toString());
        applicationEventPublisher.publishEvent(event);
    }


}
