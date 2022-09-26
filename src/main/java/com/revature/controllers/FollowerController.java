package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.dtos.FollowRequest;
import com.revature.dtos.FollowReturn;
import com.revature.models.Follower;
import com.revature.services.FollowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/follow")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class FollowerController {
    private static final Logger logger = Logger.getLogger(FollowerController.class.getName());
    private static final Level logLevel = Level.INFO;
    private final FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;

    }

    @Authorized
    @GetMapping("/{var}")
    public ResponseEntity<List<FollowReturn>> getFollowers(@PathVariable String var) {
        logger.log(Level.INFO,"Made it here to get followers");
        return ResponseEntity.ok(this.followerService.getFollowers(Integer.valueOf(var)));

    }

    @Authorized
    @PatchMapping
    public ResponseEntity<Void> follow(@RequestBody FollowRequest body) {


        logger.log(logLevel, "authenticated user");
        logger.log(logLevel, "userId: " + body.getId());
        logger.log(logLevel, "followingId: " + body.getEmail());
        logger.log(logLevel, "buttonState: " + body.getState());
        followerService.follow(body);
        return ResponseEntity.ok().build();

    }

}
