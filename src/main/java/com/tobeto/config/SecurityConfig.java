package com.tobeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tobeto.filter.JwtAuthorizationFilter;

@Configuration
public class SecurityConfig {
	@Autowired
	private JwtAuthorizationFilter jwtAuthorizationFilter;

	@Bean
	SecurityFilterChain filterRoles(HttpSecurity http) throws Exception {
		System.out.println("admin filtresi calisiyor..");
		// @formatter:off
		http
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(authorize -> authorize			    
			    .requestMatchers("/api/v1/stock/get/**", "/api/v1/stockalert/**", "/api/v1/employee/edit/password").hasRole("rapor_kullanicisi")
			    .requestMatchers("/api/v1/shelf/**", "/api/v1/stockalert/**", "/api/v1/employee/edit/password").hasRole("depo_sorumlusu")
			    .requestMatchers("/api/v1/employee/del", "/api/v1/employee/add", "/api/v1/employee/edit/password", "/api/v1/stock/**", "/api/v1/shelf/**").hasRole("admin")
			    .requestMatchers("/api/v1/**").denyAll()
			    .anyRequest().authenticated()
				)
		     .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		     .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		// @formatter:on

		return http.build();
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
