package com.example.demo;

import feign.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = UserService.class)
public class DemoApplication {



    public static void main(String[] args) {
         SpringApplication.run(DemoApplication.class, args);
    }

}
