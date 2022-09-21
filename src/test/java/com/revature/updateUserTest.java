package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.revature.controllers.AuthController;
import com.revature.controllers.ProfileController;
import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.AuthService;
import com.revature.services.ProfileService;
import com.revature.services.UserService;

@SpringBootTest
public class updateUserTest {
	
	private static final Logger logger = Logger.getLogger(updateUserTest.class.getName());
	private static final Level logLevel = Level.INFO;

	@Autowired
	private AuthController controller;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthService authService;
	    
	@Autowired
	private ProfileService profileService;
	    
	@Autowired
	private UserController userController;
	    
	@Autowired
	private ProfileController profileController;
	

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    
    @Test
    public void updateUser() throws Exception{
    	User u = new User(1, "email@email.com", "password", "Jay", "Byrd");
    	userService.saveOrUpdateUser(u);
    	Optional<User> user = userRepository.findByEmail(u.getEmail());
    	
    	if(user.isPresent()) {
    		assertTrue(user.get().getEmail().equals(u.getEmail()));
    		assertTrue(user.get().getFirstName().equals(u.getFirstName()));
    		assertTrue(user.get().getLastName().equals(u.getLastName()));

    	}
    	
    }
	    
	    
	    

}
