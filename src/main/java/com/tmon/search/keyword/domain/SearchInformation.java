package com.tmon.search.keyword.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor
@Getter
@Setter
public class SearchInformation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
