package com.xxxmkxxx.simplemed.configs.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxxmkxxx.simplemed.exception.AuthenticationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final String secret;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, String secret) {
        this.authenticationManager = authenticationManager;
        this.secret = secret;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            SignInDto signInDto = new ObjectMapper().readValue(request.getInputStream(), SignInDto.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(signInDto.username(), signInDto.password());
            return authenticationManager.authenticate(authentication);

        } catch (IOException e) {
            throw new AuthenticationException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult){
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(14)))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();

        response.addHeader("Authorization", "Bearer " + token);
    }
}
