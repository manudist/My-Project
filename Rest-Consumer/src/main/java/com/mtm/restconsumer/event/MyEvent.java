package com.mtm.restconsumer.event;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;

public class MyEvent extends ApplicationEvent {
    private final String message;

    public MyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
