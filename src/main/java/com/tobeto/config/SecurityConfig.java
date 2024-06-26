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
	String[] allRoles = { "depo_sorumlusu", "admin", "rapor_kullanicisi" };
	String[] roles = { "depo_sorumlusu", "admin" };

	@Bean
	SecurityFilterChain filterRoles(HttpSecurity http) throws Exception {
		// @formatter:off
		http
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(authorize -> authorize			    				
			    .requestMatchers("/api/v1/employee/edit/password").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/employee/edit/password/admin").hasRole("admin")
			    .requestMatchers("/api/v1/shelf/get/all").hasAnyRole(roles)
			    .requestMatchers("/api/v1/shelf/add","/api/v1/shelf/del").hasRole("admin")
			    .requestMatchers("/api/v1/stock/get/**").hasAnyRole(roles)
			    .requestMatchers("/api/v1/stock/add","/api/v1/stock/del","/api/v1/stock/put").hasRole("admin")
			    .requestMatchers("/api/v1/stock/del/decrease/quantity").hasAnyRole(roles) // 
			    .requestMatchers("api/v1/login/**").permitAll()
			    .requestMatchers("/api/v1/type/gpu/get", "/api/v1/type/gpu/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/cpu/get", "/api/v1/type/cpu/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/psu/get", "/api/v1/type/psu/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/cpucooler/get", "/api/v1/type/cpucooler/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/case/get", "/api/v1/type/case/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/motherboard/get", "/api/v1/type/motherboard/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/ram/get", "/api/v1/type/ram/get/all").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/type/**").hasRole("admin")
			    .requestMatchers("/api/v1/stockalert/add","/api/v1/stockalert/get/all","/api/v1/stockalert/del").hasAnyRole(allRoles)
			    .requestMatchers("/api/v1/employee/del", "/api/v1/employee/add").hasRole("admin")
			    .requestMatchers("/api/v1/employee/get/**","/api/v1/employee/edit/password").hasRole("admin") 
			    .requestMatchers("/api/v1/employee/get","/api/v1/employee/edit/password").hasRole("admin") 
			    .requestMatchers("/api/v1/employee/get/all").hasRole("admin")
			    //.requestMatchers("/api/v1/**").denyAll()
			    .anyRequest().denyAll()
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
