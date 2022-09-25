package com.revature.services;

import com.revature.dtos.UpdateUserRequest;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.dtos.ResetPasswordRequest;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User saveOrUpdateUser(UpdateUserRequest request) {
        Optional<User> user = userRepository.findById(request.getId());
        User u = user.orElse(null);
        if(u == null) throw new UserDoesNotExistException();
        u.setEmail(request.getEmail());
        u.setPassword(request.getPassword());
        u.setFirstName(request.getFirstName());
        u.setLastName(request.getLastName());
        userRepository.save(u);
        return u;
    public void resetPassword(ResetPasswordRequest resetPasswordRequest) {
        Optional<User> user = userRepository.findByEmail(resetPasswordRequest.getEmail());

        if(user.isPresent()){
            user.get().setPassword(resetPasswordRequest.getPassword());
            userRepository.save(user.get());
        }
    }
}
