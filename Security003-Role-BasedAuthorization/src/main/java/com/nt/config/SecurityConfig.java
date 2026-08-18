package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.requestMatchers("/home").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(form -> form.defaultSuccessUrl("/home", true));

		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {

		UserDetails user = User.builder().username("user").password("{noop}user123").roles("USER").build();

		UserDetails admin = User.builder().username("anand").password("{noop}anand123").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}