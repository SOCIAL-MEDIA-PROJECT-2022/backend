package com.revature.post;

import com.revature.controllers.PostController;
import com.revature.dtos.LikeRequest;
import com.revature.models.Follower;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.PostService;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LikePostTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostController postController;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() throws Exception {
        assertThat(postRepository).isNotNull();
        assertThat(postService).isNotNull();
        assertThat(userRepository).isNotNull();

    }

    @Test
    void getAllPosts() {
        Optional<List<Post>> allPosts = this.postRepository.findAllByTextNotNull();
        assertTrue(allPosts.isPresent());
        System.out.println(allPosts.get().size());
        for (Post p : allPosts.get())
            System.out.println(p.getText());
    }

    @Test
    void likePost(){
        userService.save(new User(1, "poster@email.com", "password", "Post", "Er", new LinkedList<Follower>()));
        Optional<User> poster = userRepository.findByEmail("poster@email.com");
        assertThat(poster.isPresent());

        postRepository.save(new Post(new LinkedList<User>(), 1, "this is a test post", " ", new LinkedList<>(), poster.get(), false));
        Optional<List<Post>> postersPosts = postRepository.findPostsByAuthor(poster.get());
        assertThat(postersPosts.isPresent());


        userService.save(new User(1, "liker@email.com", "password", "Post", "Er", new LinkedList<Follower>()));
        Optional<User> liker = userRepository.findByEmail("liker@email.com");
        assertThat(liker.isPresent());

        LikeRequest likerLikesPostersPost = new LikeRequest(postersPosts.get().get(0).getId(), liker.get().getId());
        Post updatedPost = postService.updateLikes(likerLikesPostersPost);
        assertEquals(1, updatedPost.getLikes().size());
    }

    @Test
    void returnPostsByAuthor(){
        User u = userService.save(new User(1, "author@email.com", "password", "Post", "Er", new LinkedList<>()));
        postRepository.save(new Post(new LinkedList<>(), 1, "this is a test post", " ", new LinkedList<>(), u, false));
        postRepository.save(new Post(new LinkedList<>(), 1, "this is a test post", " ", new LinkedList<>(), u, false));
        postRepository.save(new Post(new LinkedList<>(), 1, "this is a test post", " ", new LinkedList<>(), u, false));
        postRepository.save(new Post(new LinkedList<>(), 1, "this is a test post", " ", new LinkedList<>(), u, true));
        Optional<List<Post>> postsByAuthor = postService.findPostsByAuthor(u);
        assertThat(postsByAuthor.isPresent());
        assertEquals(u.getId(), postsByAuthor.get().get(0).getAuthor().getId());
    }

    @Test
    void updatePostInRepo(){
        User u = userService.save(new User(1, "allPostsAuthor@email.com", "password", "Post", "Er", new LinkedList<>()));
        postRepository.save(new Post(new LinkedList<>(), 1, "this is a test post", " ", new LinkedList<>(), u, false));

        Optional<List<Post>> p = postService.findPostsByAuthor(u);
        p.get().get(0).setText("This is now an updated post.");
        Post updatedPost = postRepository.save(p.get().get(0));
        assertEquals("This is now an updated post.", updatedPost.getText());
    }

}