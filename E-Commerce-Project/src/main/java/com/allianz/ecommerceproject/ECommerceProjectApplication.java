package com.allianz.ecommerceproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ECommerceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceProjectApplication.class, args);
    }

}
