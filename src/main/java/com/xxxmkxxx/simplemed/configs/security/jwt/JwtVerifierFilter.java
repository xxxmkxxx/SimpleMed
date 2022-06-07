package com.xxxmkxxx.simplemed.configs.security.jwt;

import com.xxxmkxxx.simplemed.exception.AuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtVerifierFilter extends OncePerRequestFilter {
    private final String secret;

    public JwtVerifierFilter(String secret) {
        this.secret = secret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (!isBearerAuthorization(authorizationHeader)) {
            filterChain.doFilter(request, response);
            return;
        }

        Claims body = parseToken(extractJwt(authorizationHeader)) ;

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                body.getSubject(), null, parseAuthorities(body.get("authorities"))
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private Set<SimpleGrantedAuthority> parseAuthorities(Object authoritiesList) {
        var authorities = (List<Map<String, String>>) authoritiesList;
        return authorities.stream()
                .map(a -> new SimpleGrantedAuthority(a.get("authority")))
                .collect(Collectors.toSet());
    }

    private String extractJwt(String authorizationHeader) {
        return authorizationHeader.replace("Bearer ", "");
    }

    private boolean isBearerAuthorization(String authorizationHeader) {
        return !Strings.isBlank(authorizationHeader) && authorizationHeader.startsWith("Bearer ");
    }

    private Claims parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parseClaimsJws(token).getBody();
        } catch (JwtException e) {
            throw new AuthenticationException("The token '" + token + "' cannot be trusted!");
        }
    }
}
