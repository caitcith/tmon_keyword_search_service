package com.tmon.search.keyword.configuration;
import com.mongodb.MongoClient;
import com.tmon.search.keyword.client.UrlPreparedRestTemplate;
import com.tmon.search.keyword.service.CryptographyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    public @Bean MongoClient mongoClient() {
        return new MongoClient("localhost");
    }

    public @Bean MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "keyword");
    }

    public @Bean
    UrlPreparedRestTemplate kakaoUrlPreparedRestTemplate(
            @Value("${kakao.restapi.base.url}")
            String baseUrl,
            @Value("${kakao.restapi.local.search.path}")
            String path,
            @Value("${kakao.restapi.authorization.key}")
            String key) {

        return new UrlPreparedRestTemplate(baseUrl, path, key);
    }
}