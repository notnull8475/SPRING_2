package ru.gb.springone.market.auth.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.gb.springone.market.auth.services.AppUserService;


@Configuration
public class SecurityConfiguration {

    // client -> [username, password] -> /auth
    // service -> [token] -> client

    // client -> [token] -> /resource

//    @Autowired
//    private JwtRequestFilter filter;
    @Autowired
    private AppUserService userService;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return webSecurity -> webSecurity.ignoring().requestMatchers("/auth");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests()
                .requestMatchers("/api/v1/products/**")
                .permitAll()
                .requestMatchers("/api/v1/admin/users/**")
                .hasAnyAuthority("ROOT")
                .requestMatchers("/api/v1/users/**","/api/v1/roles/**")
                .hasAnyAuthority("ADMIN", "ROOT")
                .requestMatchers("/api/v1/admin/products/**")
                .hasAnyAuthority("MANAGER", "ROOT")
                .and()
//                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider... authenticationProviders) {
        return new ProviderManager(authenticationProviders);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}
