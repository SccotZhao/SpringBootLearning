package com.example.firtproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class FirstprojectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstprojectApplication.class, args);
		System.out.println("Welome Scott to your first project.");
		
		Alien alien = context.getBean(Alien.class);
		alien.print();
	}

}
