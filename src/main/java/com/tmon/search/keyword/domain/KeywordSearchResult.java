package com.tmon.search.keyword.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;


@Data
public class KeywordSearchResult {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double latitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double longitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long searchHit;
}
