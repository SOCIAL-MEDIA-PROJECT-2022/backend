package com.revature.services;


import com.revature.models.Profile;
import com.revature.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
	private static final Logger logger = Logger.getLogger(ProfileService.class.getName());
	private static final Level logLevel = Level.INFO;
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile saveOrUpdateProfile(Profile p) {
        logger.log(logLevel, p.toString());
        profileRepository.save(p);
        return profileRepository.getById(p.getId());
    }

    public List<Profile> getAll() {
        return this.profileRepository.findAll();
    }

    public Profile getById(int id) {

        List<Profile> profileList = profileRepository.findAll();
        Optional<Profile> profile= Optional.empty();

        for (Profile p : profileList) {
            if (p.getUserId()== id) {
                profile = Optional.of(p);
            }
        }

		if(profile.isEmpty()){
			Profile newProfile = new Profile(0,id,"About Me","Hobbies","Something Interesting","Profile Picture URL");
			profileRepository.save(newProfile);
			return newProfile;
		}
        return profile.get();


    }

}
