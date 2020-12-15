package com.wupx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wupx
 * @date 2020/12/15
 */
@SpringBootApplication
@MapperScan("com.wupx.mapper")
public class EasyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class, args);
    }

}
