package com.jonghak.firstproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 스프링의 설정 바꿀 수 있게 하는 어노테이션
public class CorsConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedOrigins("*"); // addMapping : 어떠한 매핑에 대해서 허용을 할 것인지 추가
        // "/** */" : 모든 path에 대해서 허용할 것이다
        // allowedMethods : 어떤 메소드들을 허용할 것인지 추가
        // "*" : 모든 메소드들에게 적용
        // allowedOrigins : 어떠한 출처에 대해서 허용할 것인지 추가
    }
}
