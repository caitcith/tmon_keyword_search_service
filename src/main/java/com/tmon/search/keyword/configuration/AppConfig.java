package com.tmon.search.keyword.configuration;
import com.tmon.search.keyword.service.CryptographyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CryptographyService cryptographyService() {
        return new CryptographyService();
    }
}