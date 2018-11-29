package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.KakaoKeywordSearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class KaKaoKeywordSearchServiceImpl implements KeywordSearchService{

    @Override
    public List<KakaoKeywordSearchResult> searchByKeyword(String keyword) {

        return null;
    }
}
