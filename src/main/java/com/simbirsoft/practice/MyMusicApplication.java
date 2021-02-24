package com.simbirsoft.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MyMusicApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyMusicApplication.class, args);
    }
}
