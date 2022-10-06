package ru.netology.hibernateorm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Yuri").password("{noop}1111").roles("WRITE").and().withUser("Slava")
                .password("{noop}3333").roles("WRITE").and().withUser("Ivan").password("{noop}2222").roles("READ");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().authorizeRequests().antMatchers("/persons/by-city").permitAll().and().authorizeRequests()
                .anyRequest().hasAnyRole("WRITE");
    }
}
