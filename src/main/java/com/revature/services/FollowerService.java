package com.revature.services;

import com.revature.dtos.FollowRequest;
import com.revature.dtos.FollowReturn;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.Follower;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FollowerService {
    private static final Logger logger = Logger.getLogger(FollowerService.class.getName());
    private final UserRepository userRepository;

    public FollowerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<FollowReturn> getFollowers(Integer id) {
        Optional<User> currentUser = userRepository.findById(id);
        if(currentUser.isEmpty()) throw new UserDoesNotExistException();
        List<FollowReturn> followers = new LinkedList<>();
        for(Follower f : currentUser.get().getFollowing()){
            followers.add(new FollowReturn(f.getId(), f.getEmail()));
        }
        return followers;
    }

    public void follow(FollowRequest body) {

        Optional<User> currentUser = userRepository.findById(body.getId());
        if(currentUser.isEmpty()) throw new UserDoesNotExistException();
        Optional<User> following = userRepository.findByEmail(body.getEmail());
        if(following.isEmpty()) throw new UserDoesNotExistException();
        if (currentUser.get().getId() == following.get().getId()) {
            return;
        }

        if (body.getState().equalsIgnoreCase("follow")) {
            currentUser.get().getFollowing().add(new Follower(following.get().getId(), following.get().getEmail()));
        } else {
            List<Follower> newFollowers = new LinkedList<>();
            for (Follower u : currentUser.get().getFollowing()) {
                if (!u.getEmail().equals(body.getEmail())) {
                    newFollowers.add(u);
                }

            }
            currentUser.get().setFollowing(newFollowers);
        }
        userRepository.save(currentUser.get());
    }


}
