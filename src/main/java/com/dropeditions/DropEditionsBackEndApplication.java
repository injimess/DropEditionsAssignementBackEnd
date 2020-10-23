package com.dropeditions;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.dropeditions.security.CustomUserDetailsService;
import com.dropeditions.security.JwtAuthenticationEntryPoint;
import com.dropeditions.security.JwtTokenProvider;

@SpringBootApplication
@EntityScan(basePackageClasses= {
		DropEditionsBackEndApplication.class,
		Jsr310JpaConverters.class
})
public class DropEditionsBackEndApplication {
	
	@Bean 
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean 
	public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
		return new JwtAuthenticationEntryPoint();
	}
	
	@Bean 
	public JwtTokenProvider jwtTokenProvider() {
		return new JwtTokenProvider();
	}
	
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UCT+1"));
	}

	public static void main(String[] args) {
		SpringApplication.run(DropEditionsBackEndApplication.class, args);
	}

}
