package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class configration {
	@Configuration
	@EnableWebMvc
	public class GpConfig implements WebMvcConfigurer{
		@Override
		public void addCorsMappings(CorsRegistry cr) {
			cr.addMapping("/**")
					.allowedOrigins("*")  // 허용할 주소 및 포트
					.allowedOrigins("http://localhost:8080");

		}

	}
}
