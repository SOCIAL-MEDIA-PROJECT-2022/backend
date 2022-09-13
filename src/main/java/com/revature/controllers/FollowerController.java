package com.revature.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.FollowerObject;
import com.revature.models.User;
import com.revature.services.FollowerService;

@RestController
@RequestMapping("/followers")
@CrossOrigin(origins="http://localhost:4200",allowCredentials="true")
public class FollowerController {
	private static final Logger logger = Logger.getLogger(FollowerController.class.getName());
	private final FollowerService followerService;
	
	public FollowerController(FollowerService followerService) {
		this.followerService = followerService;
		
	}
	@Authorized
	@GetMapping("/getfollowers")
	public ResponseEntity<List<FollowerObject>> getFollowers() {
		return ResponseEntity.ok(this.followerService.getFollowers());
		
	}
	@Authorized
	@PatchMapping("/follow")
	public ResponseEntity<Void> follow(@RequestBody int userId){
		//followerService.follow(userId);
		return ResponseEntity.ok().build();
		
	}
	@Authorized
	@PatchMapping
	public ResponseEntity<Void> unFollow(@RequestBody int userId){
		return ResponseEntity.ok().build();
	}

}
