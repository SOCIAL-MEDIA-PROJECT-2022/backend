
package com.revature;
import com.revature.dtos.ResetPasswordRequest;
import com.revature.repositories.UserRepository;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.revature.controllers.AuthController;
import com.revature.models.User;

@SpringBootTest
class ResetPasswordTest {

    private static final Logger logger = Logger.getLogger(ResetPasswordTest.class.getName());
    private static final Level logLevel = Level.INFO;

    @Autowired
    private AuthController controller;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;


    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void resetPassword() throws Exception {

        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest("testuser@gmail.com", "king");
        Optional<User> user = userRepository.findByEmail(resetPasswordRequest.getEmail());

        if (user.isPresent()) {
            user.get().setPassword(resetPasswordRequest.getPassword());
            userRepository.save(user.get());

            List<String> passwordList = new ArrayList<>();
            passwordList.add(user.get().getPassword());

            assertThat(passwordList != null);
            for (String u : passwordList) {
                assertTrue(u.contains(user.get().getPassword()));
            }
        }
    }

    @Test
    public void resetPassUserServiceTest() throws Exception {

        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest("testuser@gmail.com", "boss");
        userService.resetPassword(resetPasswordRequest);

        Optional<User> user = userRepository.findByEmail(resetPasswordRequest.getEmail());
        if (user.isPresent()) {
            assertTrue(user.get().getPassword().equals("boss"));
        }

    }


    @Test
    public void resetPassAuthServiceTest() throws Exception {

        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest("testuser@gmail.com", "true");
        authService.resetPassword(resetPasswordRequest);

        Optional<User> user = userRepository.findByEmail(resetPasswordRequest.getEmail());
        if (user.isPresent()) {
            assertTrue(user.get().getPassword().equals("true"));
        }
    }
}
