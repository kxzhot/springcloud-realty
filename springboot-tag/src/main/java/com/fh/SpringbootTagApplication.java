package com.fh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootTagApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTagApplication.class, args);
    }

}
