package com.revature.user;

import com.revature.models.User;
import com.revature.repositories.UserRepository;


import org.junit.jupiter.api.Test; // needs to be this one
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userRepository).isNotNull();
    }
    @Test
    public void testFindByEmail() {
        userRepository.save(new User(0,"testSpring@boot.com","password",
                "TestSpring", "Boot"));
        Optional<User> optional = this.userRepository.findByEmail("testSpring@boot.com");
        assertTrue(optional.isPresent());
        assertEquals("testSpring@boot.com", optional.get().getEmail());
    }
}