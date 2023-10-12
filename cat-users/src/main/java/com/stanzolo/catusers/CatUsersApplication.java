package com.stanzolo.catusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableAutoConfiguration
@EnableReactiveMongoRepositories
@SpringBootApplication
public class CatUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatUsersApplication.class, args);
	}

}
