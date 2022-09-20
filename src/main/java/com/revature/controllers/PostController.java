package com.revature.controllers;

import java.util.List;

import com.revature.dtos.LikeRequest;
import com.revature.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.annotations.Authorized;
import com.revature.models.Post;
import com.revature.services.PostService;

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
<<<<<<< HEAD
    @PatchMapping
=======
    @PatchMapping()
>>>>>>> 9456796b8da2020a4e94b08f09253698d1353d04
    public ResponseEntity<Post> updateLikes(@RequestBody LikeRequest request) {
        //Controller
       /* request.getPostId();
        request.getUserId();
        System.out.println("Controller:");
        System.out.println(request);
        System.out.println(request.getPostId());*/
        return ResponseEntity.ok(this.postService.updateLikes(request));
    }
}
