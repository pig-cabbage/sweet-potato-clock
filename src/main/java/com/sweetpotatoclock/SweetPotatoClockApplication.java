package com.sweetpotatoclock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.sweetpotatoclock.dao")
@SpringBootApplication
public class SweetPotatoClockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SweetPotatoClockApplication.class, args);
    }

}
