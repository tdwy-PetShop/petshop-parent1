package com.tdwy.petshopzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// zuul网关注解
@EnableZuulProxy
@EnableEurekaClient
// 服务降级注解
@EnableCircuitBreaker
@SpringBootApplication
public class PetshopZuulApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PetshopZuulApplication.class, args);
    }

}
