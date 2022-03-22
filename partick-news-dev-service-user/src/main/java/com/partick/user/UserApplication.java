package com.partick.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author partick_peng
 */
@SpringBootApplication
@MapperScan(basePackages = "com.partick.user.mapper")
@ComponentScan(basePackages = {"com.partick"})
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
