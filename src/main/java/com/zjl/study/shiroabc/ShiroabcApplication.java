package com.zjl.study.shiroabc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.zjl.study.shiroabc.dao"})
public class ShiroabcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroabcApplication.class, args);
    }

}
