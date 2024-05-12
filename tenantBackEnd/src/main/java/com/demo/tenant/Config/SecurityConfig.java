package com.demo.tenant.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http.csrf(AbstractHttpConfigurer::disable)
				.cors(cors->cors.configurationSource(corsConfigurationSource()))
				.authorizeHttpRequests(auth -> {
			//using below line we can open end point, where no auth is required to access
//			auth.requestMatchers("/login").permitAll();
			auth.anyRequest().authenticated();
		}).oauth2Login(oath2->{
			//here we can add customization for login page
			//success handler
			//failure handler
			
			
			//after success, application returns cookie which we can use
			//we get jsessionId in the cookie
		}).
				build();
		
	}
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("http://localhost:3000"));
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);
		
		
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);
		
		return urlBasedCorsConfigurationSource;
	}
	
}
