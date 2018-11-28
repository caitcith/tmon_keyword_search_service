package com.tmon.search.keyword.controller;

import com.tmon.search.keyword.domain.KeywordSearchResult;
import com.tmon.search.keyword.domain.User;
import com.tmon.search.keyword.service.KeywordSearchService;
import com.tmon.search.keyword.service.SearchInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(path="/keyword/")
public class KeywordController {
	@Autowired
	private KeywordSearchService kakaoKeywordSearchServiceImp;

	//@Autowired
	//private SearchInformationService searchInformationService;

	@GetMapping(path="/search")
	public @ResponseBody Iterable<KeywordSearchResult>
				searchKeyword(User user, @RequestParam String keyword) throws Exception {

		//searchInformationService.store(user, keyword);

		return null;
	}
}
