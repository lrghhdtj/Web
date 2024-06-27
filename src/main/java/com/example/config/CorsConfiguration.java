package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfiguration implements WebMvcConfigurer{
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*")// 允许所有源访问，可以指定具体的源
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方法
                        .allowedHeaders("*") // 允许所有请求头
                        .allowCredentials(true) // 是否允许发送Cookie
                        .maxAge(3600); // 预检请求的有效期，单位为秒
            }
}

/*
@Configuration
public class CorsConfiguration {
    @Bean
    public FilterRegistrationBeans<CorsFilter>corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addALlowedoriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source
        new UrlBasedCorsConfigurationSource;
        source.registerCorsConfiguration(pattem:"/**", conf19)
        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBeanCorsFilter > registrationBean = new FilterRegistrationBean<>(corsFilter);
        reg1strationBean.setOrder（Ordered.HIGHEST_PRECEDENCE）：1 / 确保 CorsF1lter的优先级最高
        return registrationBean;
    }
}*/
