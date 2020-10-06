package com.mtm.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.mtm.*")
@EntityScan(basePackages = "com.mtm.*")
@ComponentScan(basePackages = "com.mtm.*")
@EnableJpaAuditing
@EnableScheduling
public class NewWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewWsApplication.class, args);
	}

}
