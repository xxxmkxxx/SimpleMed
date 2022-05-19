package com.xxxmkxxx.simplemed.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/styles/**",
                "/images/**",
                "/fonts/**",
                "/scripts/**",
                "/webjars/**"
        ).addResourceLocations(
                "/WEB-INF/css/",
                "/WEB-INF/images/",
                "/WEB-INF/fonts/",
                "classpath:/scripts/",
                "classpath:/META-INF/resources/webjars/"
        );
    }
}
