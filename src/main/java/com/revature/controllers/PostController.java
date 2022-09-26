package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.dtos.LikeRequest;
import com.revature.models.Post;
import com.revature.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PostController {

    private static final Logger logger = Logger.getLogger(PostController.class.getName());
    private static final Level logLevel = Level.INFO;

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Authorized
    @GetMapping("/{val}")
    public ResponseEntity<List<Post>> getAllPosts(@PathVariable String val) {
        logger.log(logLevel, "made it here");
        return ResponseEntity.ok(this.postService.getAll(Integer.valueOf(val)));
    }

    @Authorized
    @PutMapping
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
        return ResponseEntity.ok(this.postService.upsert(post));
    }

    @Authorized
    @PatchMapping()
    public ResponseEntity<Post> updateLikes(@RequestBody LikeRequest request) {
        return ResponseEntity.ok(this.postService.updateLikes(request));
    }
}
