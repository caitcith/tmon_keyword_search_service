package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.SearchResultInfomation;

import java.util.List;

public interface KeywordSearchService {
    List<SearchResultInfomation> searchByKeyword(String keyword);
}
