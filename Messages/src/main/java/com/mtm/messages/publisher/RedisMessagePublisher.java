package com.mtm.messages.publisher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisMessagePublisher implements MessagePublisher {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void publish( String channel ,String message ) {
        template.convertAndSend(channel,message);
    }
}
