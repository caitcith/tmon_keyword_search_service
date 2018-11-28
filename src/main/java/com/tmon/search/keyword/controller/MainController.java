package com.tmon.search.keyword.controller;

import com.tmon.search.keyword.domain.User;
import com.tmon.search.keyword.repository.UserRepository;
import com.tmon.search.keyword.service.KeywordSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(path="/user/")
public class MainController {
	@Autowired
	private KeywordSearchService kakaoKeywordSearchServiceImp;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String password) {
		User user = new User();

		user.setName(name);
		user.setPassword(password);

		userRepository.save(user);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}
