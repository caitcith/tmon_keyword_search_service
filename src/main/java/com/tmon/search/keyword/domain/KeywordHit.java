package com.tmon.search.keyword.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class KeywordHit {
    @Id
    private String _id;
    private Long count;
}
