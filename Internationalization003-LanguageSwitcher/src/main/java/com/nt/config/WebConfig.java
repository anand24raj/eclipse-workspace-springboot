package com.nt.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	/*
	 * Loads messages.properties and language-specific files such as
	 * messages_hi.properties.
	 */
	@Bean
	MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}

	/*
	 * Stores the selected language in the HTTP session. English is the default
	 * language.
	 */
	@Bean
	LocaleResolver localeResolver() {

		SessionLocaleResolver localeResolver = new SessionLocaleResolver();

		localeResolver.setDefaultLocale(Locale.ENGLISH);

		return localeResolver;
	}

	/*
	 * Reads the language from:
	 *
	 * ?lang=en ?lang=hi
	 */
	@Bean
	LocaleChangeInterceptor localeChangeInterceptor() {

		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

		interceptor.setParamName("lang");

		return interceptor;
	}

	/*
	 * Registers the LocaleChangeInterceptor with Spring MVC.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(localeChangeInterceptor());
	}
}