package com.example.soccer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            // 모든 HTTP Method를 허용한다.
            .allowedMethods("*")
            // HTTP 요청의 Header에 어떤 값이든 들어갈 수 있도록 허용한다.
            .allowedHeaders("*")
            // 자격증명 사용을 허용한다.
            // 해당 옵션 사용시 allowedOrigins를 * (전체)로 설정할 수 없다.
            .allowCredentials(true);
    }
}
