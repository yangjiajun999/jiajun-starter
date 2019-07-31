package com.jiajun.starter.web;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan(value = "com.jiajun.starter")
@MapperScan(basePackages = "com.jiajun.starter.*.mapper")
public class WebStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStarterApplication.class, args);
	}

}
