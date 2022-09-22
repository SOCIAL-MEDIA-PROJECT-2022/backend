package com.revature.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import com.revature.dtos.PostRequest;
import com.revature.models.FollowerObject;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;

@Service
public class PostService {
	
	private static final Logger logger = Logger.getLogger(PostService.class.getName());
	private static final Level logLevel = Level.INFO;


	private PostRepository postRepository;
	private UserRepository userRepository;
	
	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	public List<Post> getAll(PostRequest postRequest) {
		
		Optional <User> user = userRepository.findById(postRequest.getId());
		
		List <Post> posts = postRepository.findAllByComment(false);
		
		List <Integer> followingId = new LinkedList<>();
		
		
		
		for(FollowerObject u : user.get().getFollowing()) {
			followingId.add(u.getId());
		}
		followingId.add(user.get().getId());
		
		List <Post> retVal = new LinkedList<>();
		
		for(Post p : posts) {
			if(followingId.contains(p.getAuthor().getId())) {
				retVal.add(p);
			}
		}
		
		logger.log(logLevel, "returning form get all posts");
		
		return retVal;
	}

	public Post upsert(Post post) {
		 logger.log(Level.INFO, post.toString()); return this.postRepository.save(post);
	}
}
