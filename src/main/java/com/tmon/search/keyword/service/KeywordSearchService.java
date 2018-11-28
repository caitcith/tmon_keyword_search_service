package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.KeywordSearchResult;

import java.util.List;

public interface KeywordSearchService {
    List<KeywordSearchResult> searchByKeyword(String keyword);
}
