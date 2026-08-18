package com.nt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.interceptor.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer 
{
	private final AuthInterceptor authInterceptor;

	public WebConfig(AuthInterceptor authInterceptor) 
	{
		this.authInterceptor = authInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// Protect only profile page
		registry.addInterceptor(authInterceptor)
				.addPathPatterns("/profile");
	}
}