package com.xxxmkxxx.simplemed.configs.security;

import com.xxxmkxxx.simplemed.configs.security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.xxxmkxxx.simplemed.configs.security.jwt.JwtVerifierFilter;
import com.xxxmkxxx.simplemed.features.user.services.UserCredenceService;
import com.xxxmkxxx.simplemed.features.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RequiredArgsConstructor
@Configuration
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserCredenceService userCredenceService;
    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), secret))
                .addFilterAfter(new JwtVerifierFilter(secret), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                .antMatchers("/patient/card", "/get").hasAnyRole("USER", "STAFF", "SUPER_ADMIN")
                .antMatchers("/patient/appointments").hasAnyRole("USER", "SUPER_ADMIN")
                .antMatchers("/staff/get").hasAnyRole("USER", "STAFF", "SUPER_ADMIN")
                .antMatchers("/registry/appointments").permitAll()
                .antMatchers("/registry/appointment").hasAnyRole("USER", "STAFF", "SUPER_ADMIN")
                .anyRequest()
                .authenticated()
        ;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userCredenceService);

        return daoAuthenticationProvider;
    }
}
