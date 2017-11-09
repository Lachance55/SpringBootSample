package com.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication(scanBasePackages={"com.springboot"})
public class SpringBootRestApiApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootRestApiApp.class).headless(false).run(args);
	}
}
