package com.revature.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.dtos.PostRequest;
import com.revature.models.Post;
import com.revature.services.PostService;

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
    @PostMapping
    public ResponseEntity<List<Post>> getAllPosts(@RequestBody PostRequest postRequest) {
    	logger.log(logLevel, "made it here");
    	return ResponseEntity.ok(this.postService.getAll(postRequest));
    }
    
    @Authorized
    @PutMapping
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
    	return ResponseEntity.ok(this.postService.upsert(post));
    }
}
