package com.mtm.messages.manager;

import com.mtm.messages.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MessageManager {
    // @Autowired
    // private RedisSubscriber subscriber;
    @Autowired
    private MessagePublisher publisher;
    @Autowired
    private RedisMessageListenerContainer redisMessageListenerContainer;


    public void subscribe(String channel, Consumer<Message> consumer) {
        redisMessageListenerContainer.addMessageListener((message, pattern) -> consumer.accept(message), ChannelTopic.of(channel));
    }

    public void publish(String channel, String message) {
        publisher.publish(channel, message);
    }
   /* public void consume(String channel, Consumer<Message> consumer){
        subscriber.getConsumerList();
    }*/
}
