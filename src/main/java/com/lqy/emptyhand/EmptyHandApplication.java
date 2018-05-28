package com.lqy.emptyhand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmptyHandApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmptyHandApplication.class, args);
    }
}
