package com.uranus.fusion.transformer.cat48;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Cat48TransformerApp {
    public static void main(String[] args) {
        SpringApplication.run(Cat48TransformerApp.class, args);
    }
}
