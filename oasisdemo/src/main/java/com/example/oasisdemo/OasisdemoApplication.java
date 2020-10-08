package com.example.oasisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = {"com.example.oasisdemo.data"})
public class OasisdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OasisdemoApplication.class, args);
    }

}
