package com.ssf.day11workshop;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11WorkshopApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Day11WorkshopApplication.class);

		String port = portFromCommandLine(args);

		if (port == null) {
			port = portFromEnvironment();
		}

		if (port == null){
			port = "3000";
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		System.out.println("Application started on port " + port);
		app.run(args);
	}

	private static String portFromCommandLine(String[] args){
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		if (cliOpts.containsOption("port")) {
			return cliOpts.getOptionValues("port").get(0);
		}
		return null;
	}

	private static String portFromEnvironment(){
		String port = System.getenv("PORT");
		if (port != null){
			return port;
		}
		return null;
	}
}