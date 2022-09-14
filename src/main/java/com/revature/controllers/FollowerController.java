package com.revature.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
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
@RequestMapping("/follow")
@CrossOrigin(origins="http://localhost:4200",allowCredentials="true")
public class FollowerController {
	private static final Logger logger = Logger.getLogger(FollowerController.class.getName());
	private static final Level logLevel = Level.INFO;
	private final FollowerService followerService;
	
	public FollowerController(FollowerService followerService) {
		this.followerService = followerService;
		
	}
	@Authorized
	@GetMapping
	public ResponseEntity<List<FollowerObject>> getFollowers() {
		return ResponseEntity.ok(this.followerService.getFollowers());
		
	}
	@Authorized
	@PatchMapping
	public ResponseEntity<Void> follow(@RequestBody HashMap<String, String> body){
		
		logger.log(logLevel,"authenticated user");
		logger.log(logLevel,"userId: " + body.get("userId"));
		logger.log(logLevel,"followingId: " + body.get("email"));
		logger.log(logLevel, "buttonState: " + body.get("state"));
		followerService.follow(body);
		return ResponseEntity.ok().build();
		
	}

}
