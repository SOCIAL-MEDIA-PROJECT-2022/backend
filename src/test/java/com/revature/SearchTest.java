package com.revature;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.revature.controllers.SearchController;
import com.revature.models.User;
import com.revature.services.SearchService;

@SpringBootTest
class SearchTest {
	
	private static final Logger logger = Logger.getLogger(SearchTest.class.getName());
	private static final Level logLevel = Level.INFO;
	
	@Autowired
	private SearchController controller;
	
	@Autowired
	private SearchService searchService;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void search() throws Exception {
		
		String pattern = "test";
		
		List<User> userList = searchService.search(pattern);
		assertThat(userList != null);
		for(User u : userList) {
			assertThat(u.getEmail().contains(pattern));
		}
	}
	
	@Test
	public void anotherSearch() throws Exception {
		
		String pattern = "bob";
		
		List<User> userList = searchService.search(pattern);
		assertThat(userList != null);
		for(User u : userList) {
			
			logger.log(logLevel, u.toString());
			
			assertThat(u.getEmail().contains(pattern));
		}
	}
	
}
	





