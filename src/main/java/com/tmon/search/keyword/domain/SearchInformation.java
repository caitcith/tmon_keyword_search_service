package com.tmon.search.keyword.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
public class SearchInformation {
    @Id
    private String id;
    private String keyword;
    private String userId;
    public SearchInformation(String keyword, String userId) {
        this.keyword = keyword;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return String.format(
                "SearchInformation[id=%s, keyword=%s, userId=%s",
                id, keyword, userId);
    }
}
