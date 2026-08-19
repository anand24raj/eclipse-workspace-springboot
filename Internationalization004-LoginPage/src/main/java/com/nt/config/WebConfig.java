package com.nt.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@ComponentScan("com.nt")
public class WebConfig implements WebMvcConfigurer {

	// ==============================
	// JSP View Resolver
	// ==============================
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/WEB-INF/pages/", ".jsp");
	}

	// ==============================
	// Message Source
	// ==============================
	@Bean
	MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}

	// ==============================
	// Locale Resolver
	// ==============================
	@Bean
	LocaleResolver localeResolver() {

		SessionLocaleResolver localeResolver = new SessionLocaleResolver();

		localeResolver.setDefaultLocale(Locale.ENGLISH);

		return localeResolver;
	}

	// ==============================
	// Language Change Interceptor
	// ==============================
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {

		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

		interceptor.setParamName("lang");

		return interceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(localeChangeInterceptor());
	}
}