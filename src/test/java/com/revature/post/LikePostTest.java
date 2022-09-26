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
    public void getAllPosts(){
        Optional<List<Post>> allPosts = this.postRepository.findAllByTextNotNull();
        assertTrue(allPosts.isPresent());
        System.out.println(allPosts.get().size());
        for (Post p: allPosts.get())
            System.out.println(p.getText());
    }


}
