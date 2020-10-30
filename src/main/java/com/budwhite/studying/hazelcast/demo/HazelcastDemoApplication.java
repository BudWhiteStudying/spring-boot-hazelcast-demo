package com.budwhite.studying.hazelcast.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan
public class HazelcastDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastDemoApplication.class, args);
	}

}
