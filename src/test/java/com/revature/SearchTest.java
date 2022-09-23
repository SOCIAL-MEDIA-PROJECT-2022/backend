package com.revature;

import com.revature.controllers.SearchController;
import com.revature.dtos.SearchReturn;
import com.revature.models.Profile;
import com.revature.models.User;
import com.revature.services.SearchService;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class SearchTest {
	
	private static final Logger logger = Logger.getLogger(SearchTest.class.getName());
	private static final Level logLevel = Level.INFO;
	
	@Autowired
	private SearchController controller;
	
	@Autowired
	private SearchService searchService;
	


	@Autowired
	private UserService userService;
	


	@Test
	public void contextLoads(){
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void search() {
		
		String pattern = "test";
		
		List<SearchReturn> userList = searchService.search(pattern);
		assertThat(userList != null);
		for(SearchReturn u : userList) {


			assertTrue(u.getEmail().contains(pattern));



		}
	}
	
	@Test
	public void anotherSearch(){
		
		String pattern = "bob";

		List<SearchReturn> userList = searchService.search(pattern);
		assertThat(userList != null);
		for(SearchReturn u : userList) {


			assertTrue(u.getEmail().contains(pattern));
		}
	}
	
	@Test
	public void addAndSearch(){
		
		String pattern = "am";

		User newUser = new User(1,"james@email.com", "password", "james", "walker", "picture", "aboutme");

		userService.save(newUser);

		List<SearchReturn> userList = searchService.search(pattern);
		
		assertThat(userList != null);
		for(SearchReturn u : userList) {
			assertTrue(u.getEmail().contains(pattern));

			logger.log(logLevel, u.toString());
		
			assertTrue(u.getEmail().contains(pattern));

		}
	}
	
}





