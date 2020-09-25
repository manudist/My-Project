package com.mtm.messages.publisher;

public interface MessagePublisher {
    void publish(String channel ,String message);
}
