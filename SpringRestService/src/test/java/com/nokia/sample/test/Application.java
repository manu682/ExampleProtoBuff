package com.nokia.sample.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.nokia.sample")
@EnableAutoConfiguration(exclude=ErrorMvcAutoConfiguration.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
