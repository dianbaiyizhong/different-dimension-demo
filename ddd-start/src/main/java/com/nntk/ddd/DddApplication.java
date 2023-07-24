package com.nntk.ddd;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.nntk.ddd.infra.repository.mapper")
public class DddApplication {

    public static void main(String[] args) {

        SpringApplication.run(DddApplication.class, args);

    }


}
