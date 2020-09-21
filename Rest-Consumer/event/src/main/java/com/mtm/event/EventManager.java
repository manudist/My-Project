package com.mtm.event;

import com.mtm.event.model.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;


@Component
public class EventManager implements ApplicationListener<MyEvent>, com.mtm.event.api.EventManager {
    private final Logger logger = LoggerFactory.getLogger(EventManager.class);
    private final ApplicationEventPublisher applicationEventPublisher;
    private final HashMap<String, List<Consumer<MyEvent>>> subscribersMap;
    private final HashMap<String, List<Consumer<MyEvent>>> consumersMap;


    public EventManager(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.subscribersMap = new HashMap<>();
        this.consumersMap = new HashMap<>();
    }

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        //gestione delle subscribe
        if (subscribersMap.containsKey(myEvent.getTopic()) && subscribersMap.get(myEvent.getTopic()) != null) {
            subscribersMap.get(myEvent.getTopic()).forEach(eventConsumer -> {
                eventConsumer.accept(myEvent);
            });
        }
        //gestione delle consume
        if (consumersMap.containsKey(myEvent.getTopic()) && consumersMap.get(myEvent.getTopic()) != null) {
            consumersMap.get(myEvent.getTopic()).stream().findFirst().ifPresent(myEventConsumer -> myEventConsumer.accept(myEvent));
        }

    }

    @Override
    public void subscribeToEvent(Consumer<MyEvent> eventConsumer, String topic) {
        //controllo che la chiave sia presente e che la lista associata non sia null
        if (!subscribersMap.containsKey(topic) || subscribersMap.get(topic) == null) {
            subscribersMap.put(topic, new ArrayList<>());
        }
        subscribersMap.get(topic).add(eventConsumer);
    }

    @Override
    public void consumeEvent(Consumer<MyEvent> eventConsumer, String topic) {
        //controllo che la chiave sia presente e che la lista associata non sia null
        if (!consumersMap.containsKey(topic) || consumersMap.get(topic) == null) {
            consumersMap.put(topic, new ArrayList<>());
        }
        consumersMap.get(topic).add(eventConsumer);
    }


    @Override
    public void publishEvent(MyEvent myEvent) {
        logger.info("sending event : " + myEvent.toString());
        applicationEventPublisher.publishEvent(myEvent);
    }


}
