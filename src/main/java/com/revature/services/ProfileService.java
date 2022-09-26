package com.revature.services;


import com.revature.dtos.UpdateProfileRequest;
import com.revature.exceptions.ProfileNotFoundException;
import com.revature.models.Profile;
import com.revature.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProfileService {
    private static final Logger logger = Logger.getLogger(ProfileService.class.getName());
    private static final Level logLevel = Level.INFO;
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile saveOrUpdateProfile(UpdateProfileRequest request) {
        logger.log(logLevel, "Got to profile service");
        logger.log(logLevel, request.toString());
        Optional<Profile> profile = profileRepository.findById(request.getId());
        Profile p = profile.orElse(null);
        if (p == null) throw new ProfileNotFoundException();
        p.setAboutMe(request.getAboutMe());
        p.setHobbies(request.getHobbies());
        p.setSomethingElse(request.getSomethingElse());
        p.setProfilePic(request.getProfilePic());
        profileRepository.save(p);
        return p;
    }

    public List<Profile> getAll() {
        return this.profileRepository.findAll();
    }

    public Profile getById(int id) {

        List<Profile> profileList = profileRepository.findAll();
        Optional<Profile> profile = Optional.empty();

        for (Profile p : profileList) {
            if (p.getUserId() == id) {
                profile = Optional.of(p);
            }
        }

        if (profile.isEmpty()) {
            Profile newProfile = new Profile(0, id, "About Me", "Hobbies", "Something Interesting", "Profile Picture URL");
            profileRepository.save(newProfile);
            return newProfile;
        }
        return profile.get();


    }

}
