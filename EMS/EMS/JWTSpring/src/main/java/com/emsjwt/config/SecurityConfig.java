package com.emsjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.emsjwt.jwt.EntryPointJwt;
import com.emsjwt.jwt.TokenFilter;
import com.emsjwt.service.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(		
		prePostEnabled = true)
public class SecurityConfig { 
	@Autowired
	EntryPointJwt epj;
	@Autowired
	TokenFilter tf;
	@Autowired
	UserDetailsServiceImpl uss;
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(uss);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
  public SecurityFilterChain doFilter(HttpSecurity http) throws Exception {
    http
    .csrf().disable()
    .exceptionHandling()
    	.authenticationEntryPoint(epj)
    	.and()
    .sessionManagement()
    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and()
	.authorizeRequests()
		.requestMatchers("/public/**").permitAll()
		.requestMatchers("/user/**").authenticated()
		.requestMatchers("/admin/**").authenticated()
		.requestMatchers("/filtered/**").authenticated();
    http.authenticationProvider(daoAuthenticationProvider());
    http.addFilterBefore(tf, UsernamePasswordAuthenticationFilter.class);	
		
    return http.build();
  }
}