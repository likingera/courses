package com.courses.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({ "com.courses.*"})
public class CourseRun {

	
	public static void main(String... args) {
		
		SpringApplication.run(CourseRun.class, args);
		
	}

}
