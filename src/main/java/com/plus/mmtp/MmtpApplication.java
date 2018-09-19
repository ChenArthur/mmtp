package com.plus.mmtp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.plus.mmtp.mapper")
public class MmtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmtpApplication.class, args);
    }
}
