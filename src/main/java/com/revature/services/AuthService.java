package com.revature.services;

import com.revature.dtos.ResetPasswordRequest;
import com.revature.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthService {
    private final UserService userService;
    private final Logger logger = Logger.getLogger(AuthService.class.getName());
    private final Level logLevel = Level.INFO;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userService.findByCredentials(email, password);
    }

    public User register(User user) {
        logger.log(logLevel, "Got here with: ");
        logger.log(logLevel, user.toString());
        return userService.save(user);
    }

    public void resetPassword (ResetPasswordRequest resetPasswordRequest){
         userService.resetPassword(resetPasswordRequest);
    }
}
