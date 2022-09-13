package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.models.FollowerObject;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
@Service
public class FollowerService {
	
	private final UserRepository userRepository;
	
	public FollowerService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<FollowerObject> getFollowers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void follow(int userId) {
		User user = userRepository.getById(userId);
		
	}

}
