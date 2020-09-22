package com.mtm.event.model;

import com.mtm.event.EventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {

    private final Logger logger = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");}
}
