package com.revature.controllers;


import com.revature.annotations.Authorized;
import com.revature.dtos.LikeRequest;
import com.revature.models.Post;
import com.revature.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Authorized
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(this.postService.getAll());
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
