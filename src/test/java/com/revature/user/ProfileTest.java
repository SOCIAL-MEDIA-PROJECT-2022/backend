package com.revature.user;

import com.revature.models.Follower;
import com.revature.models.Profile;
import com.revature.models.User;
import com.revature.repositories.ProfileRepository;
import com.revature.repositories.UserRepository;
import com.revature.services.ProfileService;
import com.revature.services.UserService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProfileTest {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void getAllUsersProfile(){
        User u1 = userRepository.save(new User(1, "james11@email.com", "password", "james", "walker", new ArrayList<Follower>()));
        User u2 = userRepository.save(new User(2, "james22@email.com", "password", "james", "walker", new ArrayList<Follower>()));
        User u3 = userRepository.save(new User(3, "james33@email.com", "password", "james", "walker", new ArrayList<Follower>()));
        User u4 = userRepository.save(new User(4, "james33@email.com", "password", "james", "walker", new ArrayList<Follower>()));

        Profile p1 = profileRepository.save(new Profile(1, u1.getId(), "aboutMe", "hobbies", "somethingElse", "profilePic"));
        Profile p2 = profileRepository.save(new Profile(2, u2.getId(), "aboutMe", "hobbies", "somethingElse", "profilePic"));
        Profile p3 = profileRepository.save(new Profile(3, u3.getId(), "aboutMe", "hobbies", "somethingElse", "profilePic"));
        Profile p4 = profileRepository.save(new Profile(4, u4.getId(), "aboutMe", "hobbies", "somethingElse", "profilePic"));

        List<Profile> profiles = profileService.getAll();
        assertEquals(4 + 2, profiles.size());
    }

    @Test
    public void getUsersProfile(){
        User u = userRepository.save(new User(1, "james@email.com", "password", "james", "walker", new ArrayList<Follower>()));
        Profile createProfile = profileRepository.save(new Profile(1, u.getId(), "aboutMe", "hobbies", "somethingElse", "profilePic"));
        Profile p = profileService.getById(createProfile.getId());

        assertEquals(u.getId(), p.getUserId());
    }

}
