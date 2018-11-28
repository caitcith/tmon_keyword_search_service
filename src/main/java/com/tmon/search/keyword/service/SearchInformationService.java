package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.SearchInformation;
import com.tmon.search.keyword.domain.User;
import com.tmon.search.keyword.repository.MongoSearchInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SearchInformationService {
    @Autowired
    MongoSearchInformationRepository mongoSearchInformationRepository;

    public SearchInformation store(User user, String keyword) throws Exception {
        if (user == null) throw null;
        Optional<String> optionalKeyword = Optional.of(keyword);
        Optional<String> optionalUserName = Optional.ofNullable(user.getName());

        if (optionalKeyword.get().equals("")) {
            log.warn("skip to save empty keyword({})");
            return null;
        }

        SearchInformation searchInformation = new SearchInformation(optionalKeyword.get(),
                optionalUserName.orElseGet(() -> "unknown"));

        return mongoSearchInformationRepository.save(searchInformation);
    }
}
