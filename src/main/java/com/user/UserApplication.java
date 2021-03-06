package com.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.user.domain.mapper")
public class UserApplication {

	public static void main(String[] args){
		SpringApplication.run(UserApplication.class,args);
	}
}
