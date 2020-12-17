package com.example.stock.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ Description
 * @ Author YangYicun
 * @ Date 2020/12/17 21:22
 */
@Configuration
public class CORSConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:80");
        registry.addMapping("/**").allowedOrigins("http://localhost");
        registry.addMapping("/**").allowedOrigins("http://localhost:7890");
        registry.addMapping("/**").allowedOrigins("http://127.0.0.1:80");
        registry.addMapping("/**").allowedOrigins("http://127.0.0.1:7890");
        registry.addMapping("/**").allowedOrigins("http://139.224.238.182:80");
        registry.addMapping("/**").allowedOrigins("http://182.92.126.13:80");
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowCredentials(true).maxAge(3600)
                .allowedHeaders("*");
        super.addCorsMappings(registry);
    }
}
