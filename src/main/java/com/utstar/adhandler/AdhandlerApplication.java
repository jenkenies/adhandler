package com.utstar.adhandler;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@MapperScan("com.utstar.adhandler.mapper")
@ServletComponentScan
public class AdhandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdhandlerApplication.class, args);
    }

}
