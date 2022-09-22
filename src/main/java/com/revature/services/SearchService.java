package com.revature.services;



import java.util.LinkedList;



import java.util.LinkedList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dtos.SearchReturn;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class SearchService {
	
	 private final UserRepository userRepository;

	    public SearchService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	    
	    
	    


	public List<SearchReturn> search(String s) {
		
		List<User> userList = userRepository.findAll();
		
		List<SearchReturn> matchingUser = new LinkedList<>();
		for(User u: userList) {
			if(u.getEmail().contains(s)) {
				matchingUser.add(new SearchReturn(u.getId(), u.getEmail(), u.getFirstName(), u.getLastName()));
			}
		}
		return matchingUser;
		
		//return userRepository.findAll();

		//return userRepository.findAll();


	

		 
	}

}
