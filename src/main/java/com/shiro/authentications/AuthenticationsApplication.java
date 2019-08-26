package com.shiro.authentications;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiro.authentications.mapper")
public class AuthenticationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationsApplication.class, args);
    }

}
