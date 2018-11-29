package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.KeywordHit;
import com.tmon.search.keyword.domain.SearchInformation;
import com.tmon.search.keyword.domain.User;
import com.tmon.search.keyword.repository.MongoKeywordHitRepository;
import com.tmon.search.keyword.repository.MongoSearchInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SearchInformationService {
    @Autowired
    MongoSearchInformationRepository mongoSearchInformationRepository;
    @Autowired
    MongoKeywordHitRepository keywordHitRepository;

    public SearchInformation store(String username, String keyword) throws Exception {
        log.info("mongo pharase..{} {}", username, keyword);
        Optional<String> optionalKeyword = Optional.of(keyword);
        Optional<String> optionalUserName = Optional.ofNullable(username);

        if (optionalKeyword.get().equals("")) {
            log.warn("skip to save empty keyword({})");
            return null;
        }
        SearchInformation searchInformation = new SearchInformation(optionalKeyword.get(),
                optionalUserName.orElse("unknown"));

        log.info("mongo pharase..{}", searchInformation);
        log.info("mongo document count{}", mongoSearchInformationRepository.count());
        return mongoSearchInformationRepository.save(searchInformation);
    }

    public List<KeywordHit> getTopKeywordInfos(Long topLimit) throws Exception {
        return keywordHitRepository.getTopKeyword(topLimit);
    }
}
