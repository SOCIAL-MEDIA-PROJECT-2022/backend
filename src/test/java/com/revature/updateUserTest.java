package com.revature;

import com.revature.dtos.UpdateUserRequest;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class updateUserTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
     void updateUser() throws Exception {
        userService.save(new User(1, "email@email.com", "password", "Jay", "Byrd", new LinkedList<>()));
        UpdateUserRequest u = new UpdateUserRequest(1, "email@email.com", "password", "Jay", "Byrd");
        userService.saveOrUpdateUser(u);
        Optional<User> user = userRepository.findByEmail(u.getEmail());

        if (user.isPresent()) {
            assertEquals(user.get().getEmail(), u.getEmail());
            assertEquals(user.get().getFirstName(), u.getFirstName());
            assertEquals(user.get().getLastName(), u.getLastName());

        }

    }


}
