package com.equipe.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.equipe.api")
@EntityScan("com..equipe.api.entity")
@EnableJpaRepositories(basePackages="com.equipe.api.repository")
public class EquipeApplication {
	 private static final Logger logger = LoggerFactory.getLogger(EquipeApplication.class);
	
	 public static void main(String[] args) {
		logger.debug("Api Teams starting ....................");
		SpringApplication.run(EquipeApplication.class, args);
	}

}
