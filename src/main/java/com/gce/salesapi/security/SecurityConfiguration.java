package com.gce.salesapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/items/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/items").permitAll()
                .antMatchers(HttpMethod.PUT, "/items").permitAll()
                .antMatchers(HttpMethod.PATCH, "/items").permitAll()
                .antMatchers(HttpMethod.GET, "/sales/**").permitAll()
                .antMatchers(HttpMethod.POST,"/items/addComments").permitAll()
                .and().csrf().disable();
    }
}
