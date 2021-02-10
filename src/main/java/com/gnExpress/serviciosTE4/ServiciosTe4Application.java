package com.gnExpress.serviciosTE4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class ServiciosTe4Application extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {		
		return builder.sources(ServiciosTe4Application.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ServiciosTe4Application.class, args);
	}

}
