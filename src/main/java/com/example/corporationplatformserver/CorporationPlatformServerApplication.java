package com.example.corporationplatformserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.*.mapper")
public class CorporationPlatformServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorporationPlatformServerApplication.class, args);
    }

}