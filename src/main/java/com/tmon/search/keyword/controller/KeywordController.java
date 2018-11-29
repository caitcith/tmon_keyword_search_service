package com.tmon.search.keyword.controller;

import com.tmon.search.keyword.domain.KeywordHit;
import com.tmon.search.keyword.domain.User;
import com.tmon.search.keyword.service.KeywordSearchService;
import com.tmon.search.keyword.service.SearchInformationService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.*;

@Slf4j
@Controller
@RequestMapping(path="/keyword/")
public class KeywordController {
	@Autowired
	private KeywordSearchService kakaoKeywordSearchServiceImp;

	@Autowired
	private SearchInformationService searchInformationService;

	@GetMapping(path="/search")
	public @ResponseBody Map<String, Object>
				searchKeyword(Authentication authentication, @RequestParam String keyword) throws Exception {

		UserDetails userDetails = (UserDetails)authentication.getPrincipal();

		log.info("user information username({}) password({})",
				userDetails.getUsername(), userDetails.getPassword());

		searchInformationService.store(userDetails.getUsername(), keyword);

		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);

		return result;
	}

	@GetMapping(path="/top")
	public @ResponseBody List<KeywordHit>
			getTopKeyword(@RequestParam Long limit) throws Exception {

		return searchInformationService.getTopKeywordInfos(limit);
	}
}
