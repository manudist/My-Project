package com.mtm.RestWS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.mtm.*")
@EntityScan(basePackages = "com.mtm.*")
@ComponentScan(basePackages = "com.mtm.*")
public class RestWsApplication {

    private final Logger logger = LoggerFactory.getLogger(RestWsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestWsApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        logger.info("APPLICATION READY");
    }

}
