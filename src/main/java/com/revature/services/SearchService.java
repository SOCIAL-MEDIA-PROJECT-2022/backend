package com.revature.services;


import java.util.LinkedList;


import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class SearchService {
	
	 private final UserRepository userRepository;

	    public SearchService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	    
	    
	    


	public List<User> search(String s) {
		
		List<User> userList = userRepository.findAll();
		
		List<User> matchingUser = new LinkedList<>();
		for(User u: userList) {
			if(u.getEmail().contains(s)) {
				matchingUser.add(u);
			}
		}
		return matchingUser;
		
		//return userRepository.findAll();


	public List<User> search(String s) {
		
		return userRepository.findByEmailContains(s);

		 
	}

}
