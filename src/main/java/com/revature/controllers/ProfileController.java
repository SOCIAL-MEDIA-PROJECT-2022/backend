package com.revature.controllers;


import com.revature.annotations.Authorized;
import com.revature.dtos.UpdateProfileRequest;
import com.revature.models.Profile;
import com.revature.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProfileController {
    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());
    private static final Level logLevel = Level.INFO;
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Authorized
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable int id) {
        return ResponseEntity.ok(this.profileService.getById(id));
    }

    @Authorized
    @PatchMapping("/update")
    public ResponseEntity<Profile> updateProfile(@RequestBody UpdateProfileRequest request) {
        logger.log(logLevel, "Got here with: " + request.toString());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(profileService.saveOrUpdateProfile(request));
    }


}
