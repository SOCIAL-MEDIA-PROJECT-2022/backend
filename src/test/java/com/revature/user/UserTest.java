package com.revature.user;

import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userRepository).isNotNull();
    }
}