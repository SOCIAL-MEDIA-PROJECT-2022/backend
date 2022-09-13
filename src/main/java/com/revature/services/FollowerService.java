package com.revature.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.revature.models.FollowerObject;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
@Service
public class FollowerService {
	private static final Logger logger = Logger.getLogger(FollowerService.class.getName());
	private final UserRepository userRepository;
	
	public FollowerService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<FollowerObject> getFollowers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void follow(HashMap <String, String> body) {
		
		User currentUser = userRepository.getById(Integer.parseInt(body.get("userId")));
		
		User following = userRepository.getById(Integer.parseInt(body.get("followingId")));
		
		logger.log(Level.INFO, currentUser.toString());
		
		logger.log(Level.INFO, following.toString());
		
		currentUser.getFollowing().add(following);
		
		userRepository.save(currentUser);
		
		
		
	}
	
	public void unFollow(HashMap <String, String> body) {
		
		User currentUser = userRepository.getById(Integer.parseInt(body.get("userId")));
		
		List<User> newFollowers = new LinkedList<>();
		
		for(User u: currentUser.getFollowing()) {
			if(u.getId() != Integer.parseInt(body.get("followingId"))) {
				newFollowers.add(u);
			}
			
		}
		currentUser.setFollowing(newFollowers);
		userRepository.save(currentUser);
	}
	
	
	

}
