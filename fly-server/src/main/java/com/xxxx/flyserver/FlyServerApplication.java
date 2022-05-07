package com.xxxx.flyserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.xxxx.flyserver.mapper")
//@EnableScheduling
public class FlyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyServerApplication.class, args);
    }

}
