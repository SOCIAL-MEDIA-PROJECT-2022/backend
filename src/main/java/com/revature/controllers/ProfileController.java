package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.Profile;
import com.revature.models.User;
import com.revature.services.ProfileService;
import com.revature.services.UserService;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProfileController {
private final ProfileService profileService;
	
	public ProfileController( ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@PutMapping("/update")
	public Profile updateProfile(@RequestBody Profile p) {
		return profileService.saveOrUpdateProfile(p);
	}
	
	@Authorized
	@GetMapping("/{id}")
	public ResponseEntity<List<Profile>> getProfile(@PathVariable int id){
		return ResponseEntity.ok(this.profileService.getById(id));
		
	}

}
