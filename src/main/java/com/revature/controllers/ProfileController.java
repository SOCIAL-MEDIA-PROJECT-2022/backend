package com.revature.controllers;


import com.revature.annotations.Authorized;
import com.revature.models.Profile;
import com.revature.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProfileController {
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
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(profileService.saveOrUpdateProfile(profile));
    }

}
