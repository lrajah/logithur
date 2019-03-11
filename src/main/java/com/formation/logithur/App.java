package com.formation.logithur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * VTC
 * @author: Julie-Claire, Melody, Logithan, Jeremy (Aelion)
 * @description: Back-end, gestion vtc
 * @version: 1.0.0
 */



@SpringBootApplication
public class App 
{
	
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
    
  
}
