package com.rikkei.bai5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Bai5Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai5Application.class, args);
    }

}
