package com.stanzolo.cattrips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableAutoConfiguration
@EnableReactiveMongoRepositories
@SpringBootApplication
public class CatTripsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatTripsApplication.class, args);
	}

}
