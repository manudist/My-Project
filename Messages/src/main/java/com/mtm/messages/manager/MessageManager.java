package com.mtm.messages.manager;

import com.mtm.messages.publisher.MessagePublisher;
import com.mtm.messages.subscriber.RedisSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MessageManager {
    @Autowired
    private RedisSubscriber subscriber;
    @Autowired
    private MessagePublisher publisher;

    public void subscribe(String channel, Consumer<Message> consumer){
        subscriber.getConsumerList().add(consumer);
    }
    public void publish (String channel,String message){
        publisher.publish(channel,message);
    }
}
