package com.example.springloggin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class SpringLogginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLogginApplication.class, args);
    }

}
