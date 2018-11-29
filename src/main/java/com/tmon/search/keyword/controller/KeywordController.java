package com.tmon.search.keyword.controller;

import com.tmon.search.keyword.client.UrlPreparedRestTemplate;
import com.tmon.search.keyword.domain.KeywordHit;
import com.tmon.search.keyword.service.KeywordSearchService;
import com.tmon.search.keyword.service.SearchInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Slf4j
@Controller
@RequestMapping(path="/keyword/")
public class KeywordController {
	@Autowired
	private KeywordSearchService kakaoKeywordSearchServiceImp;

	@Autowired
	private SearchInformationService searchInformationService;

	@Autowired
	private UrlPreparedRestTemplate kakaoUrlPreparedRestTemplate;

	@GetMapping(path="/search")
	public @ResponseBody ResponseEntity<Map>
				searchKeyword(final Authentication authentication,
							  @RequestParam String keyword,
							  @RequestParam(value="size", defaultValue= "10") Long size,
							  @RequestParam(value="page", defaultValue = "1") Long page) {

		UserDetails userDetails = (UserDetails)authentication.getPrincipal();

		Map<String, Object> paramsMap = new HashMap<>();
		paramsMap.put("query", keyword);
		paramsMap.put("size", size);
		paramsMap.put("page", page);

		ResponseEntity<Map> responseEntity = kakaoUrlPreparedRestTemplate.getExchange(paramsMap);
		log.info("result : {}", responseEntity);

		log.info("user information username({}) password({})",
				userDetails.getUsername(), userDetails.getPassword());
		try {
			searchInformationService.store(userDetails.getUsername(), keyword);
		} catch (Exception e) {
			log.error("mongo keyword store error username({}) keyword({})", userDetails.getUsername(), keyword);
		}
		return responseEntity;
	}

	@GetMapping(path="/top")
	public @ResponseBody List<KeywordHit>
			getTopKeyword(@RequestParam Long limit) throws Exception {

		return searchInformationService.getTopKeywordInfos(limit);
	}
}
