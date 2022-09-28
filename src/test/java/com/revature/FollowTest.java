package com.revature;

import com.revature.controllers.AuthController;
import com.revature.controllers.FollowerController;
import com.revature.dtos.FollowRequest;
import com.revature.models.Follower;
import com.revature.models.User;
import com.revature.services.FollowerService;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FollowTest {

    @Autowired
    private FollowerController followerController;


    @Autowired
    private AuthController authController;

    @Autowired
    private FollowerService followerService;
    @Autowired
    private UserService userService;



    @Test
    public void follow() throws Exception {

        User currentUser = new User(1, "james@email.com", "password", "james", "walker", new ArrayList<Follower>());


        User following = new User(2, "user@email.com", "password", "user", "test", new ArrayList<Follower>());

        currentUser.getFollowing().add(new Follower(following.getId(), following.getEmail()));


        assertTrue(
                currentUser.getFollowing().stream().filter(u -> u.getEmail().equals(following.getEmail())).findFirst().isPresent()

        );


    }

    @Test
    public void followRequest() {

        String state = "follow";

        Integer id = 1;

        String email = "email@email.com";


        FollowRequest followRequest = new FollowRequest(id, email);

        assertEquals(id, followRequest.getId());

        assertEquals(email, followRequest.getEmail());


    }
}
