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

		Optional<Post> post = postRepository.findById(request.getPostId());
		Optional<User> user = userRepository.findById(request.getUserId());

		if (post.isPresent() && user.isPresent()){

			if(post.get().getLikes().contains(user.get())){
				post.get().getLikes().remove(user.get());

			}
			else {
				post.get().getLikes().add(user.get());
			}
		}

		if (post.isPresent()){

			return this.postRepository.save(post.get());}

		else {
			throw new LikesException();
		}
		}

		public Optional <List<Post>> findPostsByAuthor(User u){
			return this.postRepository.findPostsByAuthor(u);
		}
}
