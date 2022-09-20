package com.revature.post;

import com.revature.controllers.PostController;
import com.revature.dtos.LikeRequest;
import com.revature.models.Post;
import com.revature.models.User;
import com.revature.repositories.PostRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test; // needs to be this one
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
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


    @Test
    public void contextLoads() throws Exception {
        assertThat(postRepository).isNotNull();
        assertThat(postService).isNotNull();
        assertThat(userRepository).isNotNull();

    }
    @Test
    public void createUserForLike() {
        userRepository.save(new User(0,"testSpringBoot@like.com","password",
                "TestSpring", "BootLike"));
        Optional<User> optional = this.userRepository.findByEmail("testSpringBoot@like.com");
        assertTrue(optional.isPresent());
        assertEquals("testSpringBoot@like.com", optional.get().getEmail());
    }
    @Test
    public void createUserForPost() {
        userRepository.save(new User(0,"testSpringBoot@post.com","password",
                "TestSpring", "BootPost"));
        Optional<User> optional = this.userRepository.findByEmail("testSpringBoot@post.com");
        assertTrue(optional.isPresent());
        assertEquals("testSpringBoot@post.com", optional.get().getEmail());
    }

    @Test
    public void createAPostTest() {
        Optional<User> optional = this.userRepository.findByEmail("testSpringBoot@post.com");
        assertTrue(optional.isPresent());
        assertEquals("testSpringBoot@post.com", optional.get().getEmail());
        User testUser = optional.get();
        postRepository.save(new Post(1, "I am making a test post.", "imageUrlTotallyExists",
                new ArrayList<Post>(), testUser, new ArrayList<User>()));
    }

    @Test
    public void getAllPosts(){
        Optional<List<Post>> allPosts = this.postRepository.findAllByTextNotNull();
        assertTrue(allPosts.isPresent());
        System.out.println(allPosts.get().size());
        for (Post p: allPosts.get())
            System.out.println(p.getText());
    }

    @Test
    public void likePost() {
        Optional<User> optional = this.userRepository.findByEmail("testSpringBoot@post.com");
        assertTrue(optional.isPresent());
        Optional<List<Post>> postsFromUser = this.postRepository.findPostsByAuthor(optional.get());
        assertTrue(postsFromUser.isPresent());
        Optional<User> optionalLike = this.userRepository.findByEmail("testSpringBoot@like.com");
        assertTrue(optionalLike.isPresent());

        LikeRequest optionalLikeAndOptionalPost = new LikeRequest(postsFromUser.get().get(0).getId(), optionalLike.get().getId());

        // post controller needs to test a request
        Post returnedlike = this.postService.updateLikes(optionalLikeAndOptionalPost);
        // AFTER LIKE HAS BEEN SUBMITTED
        assertTrue(returnedlike.getLikes().contains(optionalLike.get()));

    }

}
