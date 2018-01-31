package com.gjj.springvuedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gjj.springvuedemo.dao")
public class SpringVueDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringVueDemoApplication.class, args);
	}
}
