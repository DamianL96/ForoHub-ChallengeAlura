package com.challenge.forohub.ForoHub.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests( (requests)-> requests
                .requestMatchers(HttpMethod.POST,"/topicos").permitAll()
                .requestMatchers(HttpMethod.GET,"/topicos/**").permitAll()
                .requestMatchers(HttpMethod.PUT,"/topicos/**").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/topicos/**").permitAll()
                .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
