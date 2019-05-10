package com.sweetpotatoclock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.sweetpotatoclock.dao")
@SpringBootApplication
public class SweetPotatoClockApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SweetPotatoClockApplication.class, args);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }


}
