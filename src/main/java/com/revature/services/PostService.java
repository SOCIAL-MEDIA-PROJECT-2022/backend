package com.revature.services;

import java.util.List;
import java.util.logging.Level;

import java.util.logging.Logger;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {
	
	private static final Logger logger = Logger.getLogger(PostService.class.getName());

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAll() {
		return this.postRepository.findAllByComment(false);
	}

	public Post upsert(Post post) {
		 logger.log(Level.INFO, post.toString()); return this.postRepository.save(post);
	}
}
