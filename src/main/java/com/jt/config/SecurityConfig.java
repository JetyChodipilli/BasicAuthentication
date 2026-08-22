package com.jt.config;

import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
			.csrf((csrf)->csrf.disable())
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/api/public").permitAll()
					.anyRequest().authenticated()
					
				)
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

	    UserDetails user = User
	            .withUsername("jety")
	            .password("{noop}jety123")
	            .roles("USER")
	            .build();

	    return new InMemoryUserDetailsManager(user);
	}
}

