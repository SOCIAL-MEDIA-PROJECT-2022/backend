package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.dtos.LikeRequest;
import com.revature.exceptions.LikesException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.revature.models.Post;
import com.revature.repositories.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserRepository userRepository;

	public PostService(PostRepository postRepository, UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	public List<Post> getAll() {
		return this.postRepository.findAll();
	}

	public Post upsert(Post post) {
		return this.postRepository.save(post);
	}

	public Post updateLikes(LikeRequest request) {

		/*
		Request has a user email and postID --Completed

		Get the post from the database with the postID, get the User from the database with the email --Completed

		Add the user that we retrieved to that post's list of users, update that post in the database --Completed

		Update front end to only send the postID and email of the user
		 */

		Optional<Post> post = postRepository.findById(request.getPostId());
		//Optional<User> user = userRepository.findByEmail(request.getEmail());
		Optional<User> user = userRepository.findById(request.getUserId());

		//Checking if the user and post exists in the database
		if (post.isPresent() && user.isPresent()){
			//Once we ensured that they've existed by getting the list of likes which is a list of users
			//add user to that list of likes
			post.get().getLikes().add(user.get());
		}
		System.out.print("value present, above present method");
		if (post.isPresent()){
			//saves the information into the database
			System.out.print("value present");
			return this.postRepository.save(post.get());}

		else {
			//throw a custom runtime exception


			throw new LikesException();
			//saves the information into the database
			//return this.postRepository.save(post.get());
		}

		}


}
