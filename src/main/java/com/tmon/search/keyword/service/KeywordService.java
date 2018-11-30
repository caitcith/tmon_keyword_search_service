package com.tmon.search.keyword.service;

import com.tmon.search.keyword.client.UrlPreparedRestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class KeywordService {
    @Autowired
    private UrlPreparedRestTemplate kakaoUrlPreparedRestTemplate;

    public ResponseEntity<Map> kakaoKeywordSearch(String keyword, Long size, Long page) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("query", keyword);
        paramsMap.put("size", size);
        paramsMap.put("page", page);

        ResponseEntity<Map> responseEntity = kakaoUrlPreparedRestTemplate.getExchange(paramsMap);
        log.info("result : {}", responseEntity);

        return responseEntity;
    }
}
