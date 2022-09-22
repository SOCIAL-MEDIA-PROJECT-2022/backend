package com.revature;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD
=======

>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

<<<<<<< HEAD
=======
import static org.junit.jupiter.api.Assertions.assertTrue;


>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.revature.controllers.SearchController;
import com.revature.models.User;
import com.revature.services.SearchService;
import com.revature.services.UserService;

<<<<<<< HEAD
=======
import com.revature.services.UserService;


>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
@SpringBootTest
class SearchTest {
	
	private static final Logger logger = Logger.getLogger(SearchTest.class.getName());
	private static final Level logLevel = Level.INFO;
	
	@Autowired
	private SearchController controller;
	
	@Autowired
	private SearchService searchService;
	
<<<<<<< HEAD
	@Autowired
	private UserService userService;
	
=======


	@Autowired
	private UserService userService;
	


>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
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
<<<<<<< HEAD
			assertTrue(u.getEmail().contains(pattern));
=======


			assertTrue(u.getEmail().contains(pattern));



>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
		}
	}
	
	@Test
	public void anotherSearch() throws Exception {
		
		String pattern = "bob";
		
		List<User> userList = searchService.search(pattern);
		assertThat(userList != null);
		for(User u : userList) {
<<<<<<< HEAD
=======


>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
			assertTrue(u.getEmail().contains(pattern));
		}
	}
	
	@Test
	public void addAndSearch() throws Exception {
		
		String pattern = "am";
		
		User newUser = new User(1,"james@email.com", "password", "james", "walker" );
		
		userService.save(newUser);
		
		List<User> userList = searchService.search(pattern);
		
		assertThat(userList != null);
		for(User u : userList) {
			assertTrue(u.getEmail().contains(pattern));
<<<<<<< HEAD
=======

			
			logger.log(logLevel, u.toString());
		
			assertTrue(u.getEmail().contains(pattern));

		}
	}
	
	@Test
	public void addAndSearch() throws Exception {
		
		String pattern = "am";
		
		User newUser = new User(1,"james@email.com", "password", "james", "walker" );
		
		userService.save(newUser);
		
		List<User> userList = searchService.search(pattern);
		
		assertThat(userList != null);
		for(User u : userList) {
			assertTrue(u.getEmail().contains(pattern));
>>>>>>> 629d2c92227178c47a6abd40b99dd726dfe28705
		}
	}
	
}
	





