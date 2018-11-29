package com.tmon.search.keyword.client;

import com.sun.xml.internal.xsom.impl.util.Uri;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Slf4j
public class UrlPreparedRestTemplate extends RestTemplate {

    private final String baseUrl;
    private final String path;
    private final HttpEntity<String> httpEntity;
    private static final String HTTP_AUTHORIZATION_HEADER_KEY = "Authorization";

    public UrlPreparedRestTemplate(String baseUrl, String path, String authorizationHeaderValue) {
        this.baseUrl = baseUrl;
        this.path = path;
        HttpHeaders headers = new HttpHeaders();
        headers.add(HTTP_AUTHORIZATION_HEADER_KEY, authorizationHeaderValue);
        this.httpEntity = new HttpEntity<>(headers);
    }

    public ResponseEntity<Map> getExchange(final Map<String, Object> paramsMap) throws RestClientException {
        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.baseUrl + this.path);

        paramsMap.keySet().stream().forEach(paramKey -> {
            builder.queryParam(paramKey, paramsMap.get(paramKey));
        });

        URI uri = builder.build(false).toUri();

        log.info("requestUrl({})", uri.toString());

        return this.exchange(uri.toString(), HttpMethod.GET, httpEntity, Map.class);
    }

    //TODO override not implement method and throw NotImplementException
}