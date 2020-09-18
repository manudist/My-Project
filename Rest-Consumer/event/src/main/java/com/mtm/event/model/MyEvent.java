package com.mtm.event.model;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private final String message;
    private final String topic;


    public MyEvent(Object source, String message,String topic) {
        super(source);
        this.message = message;
        this.topic=topic;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }
}
