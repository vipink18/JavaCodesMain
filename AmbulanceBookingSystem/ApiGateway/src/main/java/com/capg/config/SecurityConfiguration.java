//
//package com.capg.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityConfiguration {
//	
//	@Bean
//        public SecurityWebFilterChain webFilterChain(ServerHttpSecurity httpSecurity)
//        {
//            httpSecurity.authorizeExchange( t-> {
//            	t.anyExchange().authenticated();
//            })
//            .oauth2Client(Customizer.withDefaults())
//            .oauth2ResourceServer(t-> t.jwt(Customizer.withDefaults()) );
//            return httpSecurity.build();
//        }
//
//}