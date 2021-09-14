package com.awadhesh22791.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import reactor.core.publisher.Mono;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	@Bean
	public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
		http.csrf().disable();
		http.authorizeExchange().anyExchange().authenticated();
		http.httpBasic();
		http.exceptionHandling()/*.authenticationEntryPoint((swe,e)->Mono.fromRunnable(()->{
			swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
		}))*/.accessDeniedHandler((swe,e)->Mono.fromRunnable(()->{
			swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
		}));
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
