package com.tdwy.petshopblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableEurekaClient
//开启声明式服务调用
@EnableFeignClients
// 服务降级注解
@EnableCircuitBreaker
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PetshopBlogApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(PetshopBlogApplication.class, args);
    }

}
