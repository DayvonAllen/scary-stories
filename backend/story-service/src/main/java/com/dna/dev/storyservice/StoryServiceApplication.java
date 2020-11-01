package com.dna.dev.storyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoryServiceApplication.class, args);
    }

}
