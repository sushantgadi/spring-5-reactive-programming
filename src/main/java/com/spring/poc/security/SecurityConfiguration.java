package com.spring.poc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsRepository;

import static org.springframework.security.core.userdetails.User.withUsername;

@Configuration
public class SecurityConfiguration {

    @Bean
    UserDetailsRepository userDetailsRepository() {
        UserDetails user = withUsername("user").password("user@123").roles("USER").build();
        UserDetails admin = withUsername("admin").password("admin@123").roles("USER", "ADMIN").build();
        return new MapUserDetailsRepository(user, admin);
    }
}
