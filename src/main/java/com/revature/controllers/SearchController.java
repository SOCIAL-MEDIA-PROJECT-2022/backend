package com.revature.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.User;
import com.revature.services.SearchService;


@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SearchController {
	
	private final SearchService searchService;
	
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
	 @Authorized
	 @PostMapping
	 public ResponseEntity<List<User>> search(@RequestBody String  body){
		 
		 return ResponseEntity.ok(this.searchService.search(body));
		 
		 
	 }
	 
	
	
	
	

}
