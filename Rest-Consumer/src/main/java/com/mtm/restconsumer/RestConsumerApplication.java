package com.mtm.restconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.mtm.*")
@ComponentScan(basePackages = "com.mtm.*")

public class RestConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumerApplication.class, args);
    }

}
