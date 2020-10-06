package com.mtm.library.controller;

import com.mtm.messages.manager.MessageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message/")
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageManager messageManager;


    @PostMapping("{channel}/publish")
    public void publish(@PathVariable String channel, @RequestBody String message) {
        messageManager.publish(channel, message);
    }

    @PostMapping("{channel}/subscribe")
    public void subscribe(@PathVariable String channel) {
        messageManager.subscribe(channel, message -> logger.info(message.toString()));
    }
}
