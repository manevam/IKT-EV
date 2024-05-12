package com.ikt.event.management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
    public class SecurityConfiguration {
        @Bean
        public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            // Temporary fix - "401"
            http.csrf(httpSecurityCsrfConfigurer -> {httpSecurityCsrfConfigurer.disable();});

            http.authorizeHttpRequests(requests -> {
                // Always allow to "/access/permitted" without any authentication
                requests.requestMatchers("/api/v1/public/**").permitAll();
                requests.requestMatchers("/api/v1/mgmt/**").authenticated();
            });

            http.httpBasic(Customizer.withDefaults());
            return http.build();
        }

}
