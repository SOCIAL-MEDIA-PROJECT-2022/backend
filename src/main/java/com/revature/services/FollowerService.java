package com.revature.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.revature.dtos.FollowRequest;
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

	public List<FollowRequest> getFollowers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void follow(FollowRequest body) {
		
		User currentUser = userRepository.getById(body.getId());
		
		Optional <User> following = userRepository.findByEmail(body.getEmail());
		if(currentUser.getId() == following.get().getId()) {
			return;
		}
		
		if(body.getState().equals("follow")) {
			currentUser.getFollowing().add(new FollowerObject(following.get().getId(), following.get().getEmail()));
		}
		else {
			List<FollowerObject> newFollowers = new LinkedList<>();
			
			for(FollowerObject u: currentUser.getFollowing()) {
				if(!u.getEmail().equals(body.getEmail())) {
					newFollowers.add(u);
				}
				
			}
			currentUser.setFollowing(newFollowers);
			
		}
		
		//logger.log(Level.INFO, currentUser.toString());
		
		//logger.log(Level.INFO, following.toString());
		
		
		
		userRepository.save(currentUser);
		
		
		
	}
	
	
	
	
	

}
