package com.revature.services;

import com.revature.dtos.LikeRequest;
import com.revature.exceptions.LikesException;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.FollowerObject;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PostService {

    private static final Logger logger = Logger.getLogger(PostService.class.getName());
    private static final Level logLevel = Level.INFO;

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAll(Integer id) {

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new UserDoesNotExistException();
        List<Post> posts = postRepository.findAllByComment(false);

        List<Integer> followingId = new LinkedList<>();

        for (FollowerObject u : user.get().getFollowing()) {
            followingId.add(u.getId());
        }
        followingId.add(user.get().getId());

        List<Post> retVal = new LinkedList<>();

        for (Post p : posts) {
            if (followingId.contains(p.getAuthor().getId())) {
                retVal.add(p);
            }
        }

        logger.log(logLevel, "returning form get all posts");

        return retVal;
    }

    public Post upsert(Post post) {
        logger.log(Level.INFO, post.toString());
        return this.postRepository.save(post);
    }

    public Post updateLikes(LikeRequest request) {

        Optional<Post> post = postRepository.findById(request.getPostId());
        Optional<User> user = userRepository.findById(request.getUserId());

        if (post.isPresent() && user.isPresent()) {

            if (post.get().getLikes().contains(user.get())) {
                post.get().getLikes().remove(user.get());

            } else {
                post.get().getLikes().add(user.get());
            }
        }

        if (post.isPresent()) {

            return this.postRepository.save(post.get());
        } else {
            throw new LikesException();
        }
    }

    public Optional<List<Post>> findPostsByAuthor(User u) {
        return this.postRepository.findPostsByAuthor(u);
    }
}
