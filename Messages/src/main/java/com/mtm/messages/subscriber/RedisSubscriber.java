package com.mtm.messages.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

//@Service
public class RedisSubscriber implements MessageListener {

    private final List<Consumer<Message>> consumerList;

    public RedisSubscriber() {
        consumerList = new ArrayList<>();
    }

    public List<Consumer<Message>> getConsumerList() {
        return consumerList;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        consumerList.forEach(messageConsumer -> messageConsumer.accept(message));
    }
}
