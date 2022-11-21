package com.example.pts;

import com.example.pts.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableWebMvc
@Configuration
public class PtsApplication implements CommandLineRunner{
	@Autowired
	//PatientService patientService;
	public static void main(String[] args) {
		SpringApplication.run(PtsApplication.class, args);
	}
	@Override
	public void run(String... arg0) throws Exception { }

	@Bean
	public  WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("POST","GET","PUT")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);

			}
		};
	}

}
