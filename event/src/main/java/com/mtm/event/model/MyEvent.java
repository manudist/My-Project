package com.mtm.event.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private final String message;
    private final String topic;
    private static final Logger logger = LoggerFactory.getLogger(MyEvent.class);


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
