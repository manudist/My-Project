package com.mtm.event.api;

import com.mtm.event.model.MyEvent;

import java.util.function.Consumer;

public interface EventManager {
    public void subscribeToEvent(Consumer<MyEvent> eventConsumer, String topic);

    public void consumeEvent(Consumer<MyEvent> eventConsumer, String topic);

    public void publishEvent(MyEvent myEvent);

}
