package com.revature;
import com.revature.models.User;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import com.revature.controllers.PostController;
import com.revature.dtos.LikeRequest;
import com.revature.exceptions.LikesException;
import com.revature.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@DataJpaTest
public class LikePostTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService postService;
    @Autowired
    private PostController postController;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    void contextLoads() {
        assertThat(postController).isNotNull();
    }


}
