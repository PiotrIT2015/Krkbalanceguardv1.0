package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class Springproj1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springproj1Application.class, args);
	}
}
