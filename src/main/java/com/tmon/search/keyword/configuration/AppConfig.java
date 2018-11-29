package com.tmon.search.keyword.configuration;
import com.mongodb.MongoClient;
import com.tmon.search.keyword.service.CryptographyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {
    @Bean
    public CryptographyService cryptographyService() {
        return new CryptographyService();
    }

    public @Bean MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "keyword");
    }
}