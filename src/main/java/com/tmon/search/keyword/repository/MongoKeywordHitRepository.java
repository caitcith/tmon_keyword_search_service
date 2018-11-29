package com.tmon.search.keyword.repository;

import com.tmon.search.keyword.domain.KeywordHit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Slf4j
@Repository
public class MongoKeywordHitRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<KeywordHit> getTopKeyword(long limit) throws NullPointerException {
        if (limit < 0 || limit > 10) {
            log.warn("invalid limit value({})", limit);
            throw null;
        }
        GroupOperation groupByStateAndSumPop =
                Aggregation.group("keyword").count().as("count");
        SortOperation sortByCount = sort(new Sort(Sort.Direction.DESC, "count"));
        LimitOperation limitTopRank = limit(limit);

        Aggregation aggregation = newAggregation(groupByStateAndSumPop, sortByCount, limitTopRank);

        AggregationResults<KeywordHit> topKeywordResult = mongoTemplate.aggregate(
                aggregation, "searchInformation", KeywordHit.class);
        List<KeywordHit> keywordHitList = topKeywordResult.getMappedResults();

        log.info("top count document size {}", keywordHitList.size());

        if (topKeywordResult == null) {
            log.warn("fail to get top keyword aggregation");
            return null;
        }
        return keywordHitList;
    }
}
