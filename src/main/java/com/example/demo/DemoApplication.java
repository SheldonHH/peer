package com.example.demo;

import com.example.demo.p4p.util.P4PParameters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		P4PParameters.initialize(512,true);
		SpringApplication.run(DemoApplication.class, args);
	}

}
