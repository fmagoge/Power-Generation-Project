package com.fmagoge.powergeneration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fmagoge.powergeneration.services.PlantService;


@SpringBootApplication
@ComponentScan({ "com.fmagoge.powergeneration.*" })
public class PowerGenerationProjectApplication implements CommandLineRunner {

	@Autowired
	private PlantService plantService;
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(PowerGenerationProjectApplication.class);
        app.run(args);
	}
	
	
	@Override
    public void run(String... args) throws Exception 
    {
		plantService.save();
    }
	
}
