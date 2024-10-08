package com.example.demo;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		SpringApplication app = new SpringApplication(DemoApplication.class);
		
		System.out.println(args);
		System.out.println(args.length);
		
		/*
		 * app.setBanner(new Banner() {
		 * 
		 * @Override public void printBanner(Environment environment, Class<?>
		 * sourceClass, PrintStream out) { }
		 * 
		 * });
		 */
		
		//app.setWebApplicationType(WebApplicationType.);
		// app.setWebApplicationType(Web);
		 
		app.run(args);
	}

}
