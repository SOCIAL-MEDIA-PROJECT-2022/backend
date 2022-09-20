package com.revature.user;

import com.revature.exceptions.LikesException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@DataJpaTest
public class UserTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;



    @Test
    public void testFindById() throws Exception {
        this.entityManager.persist(new User(0,"testSpring@boot.com","password",
                "TestSpring", "Boot"));
        Optional<User> optional = this.userRepository.findById(0);
        assertTrue(optional.isPresent());
        assertEquals("testSpring@boot.com", optional.get().getEmail());
    }
}