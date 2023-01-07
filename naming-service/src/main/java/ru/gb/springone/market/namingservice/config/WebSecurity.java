package ru.gb.springone.market.namingservice.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurity {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        return http.csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and().build();
    }


}
