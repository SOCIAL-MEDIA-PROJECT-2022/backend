package com.revature.services;

import java.util.List;

import com.revature.dtos.LikeRequest;
import com.revature.models.User;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}

	public Post updateLikes(LikeRequest request) {

		/*
		Request has a user email and postID

		Get the post from the database with the postID, get the User from the database with the email

		Add the user that we retrieved to that post's list of users, update that post in the database

		Update front end to only send the postID and email of the user
		 */

		//will fix this soon
		return this.postRepository.save(request);}

}
