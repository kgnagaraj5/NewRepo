package it.sella.com.MyCoolApp.rest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

	@GetMapping("/")
	public String sayHello() {
		System.out.println("Controll Here");
		return "Hello World the time in india is " + LocalDate.now();
	}
	
	// A new end point mapping
		@GetMapping("/workout")	
		public String getWorkOut() {
			return "Had Hard 5k";
		}
		
		@GetMapping("/method") 
		public String sampleMethod() {
			return "This is for testing dev tools";
		}
}
