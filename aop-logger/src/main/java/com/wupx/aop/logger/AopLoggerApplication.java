package com.wupx.aop.logger;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wupx
 */
@SpringBootApplication
@MapperScan("com.wupx.aop.logger.mapper")
public class AopLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopLoggerApplication.class, args);
    }

}
