package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.KakaoKeywordSearchResult;

import java.util.List;

public interface KeywordSearchService {
    List<KakaoKeywordSearchResult> searchByKeyword(String keyword);
}
