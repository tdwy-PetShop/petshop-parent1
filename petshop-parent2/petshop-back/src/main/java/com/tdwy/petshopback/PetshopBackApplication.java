package com.tdwy.petshopback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PetshopBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetshopBackApplication.class, args);
    }

}
