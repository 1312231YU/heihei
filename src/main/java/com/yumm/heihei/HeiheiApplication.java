package com.yumm.heihei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.yumm.heihei.Mapper")
public class HeiheiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeiheiApplication.class, args);
    }

}
