package com.sweetpotatoclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.sweetpotatoclock.dao"})
@SpringBootApplication
public class SweetPotatoClockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SweetPotatoClockApplication.class, args);
    }

}
