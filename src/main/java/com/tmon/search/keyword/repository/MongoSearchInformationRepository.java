package com.tmon.search.keyword.repository;

import com.tmon.search.keyword.domain.SearchInformation;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface MongoSearchInformationRepository extends MongoRepository<SearchInformation, String> {

}
