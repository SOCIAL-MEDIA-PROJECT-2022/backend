package com.revature.services;



import org.springframework.stereotype.Service;

import com.revature.models.Profile;

import com.revature.repositories.ProfileRepository;

@Service
public class ProfileService {
	 private final ProfileRepository profileRepository;

	    public ProfileService(ProfileRepository profileRepository) {
	        this.profileRepository = profileRepository;
	    }

	   
	   

		public Profile saveOrUpdateProfile(Profile p) {
			// TODO Auto-generated method stub
			System.out.println(p);
			profileRepository.save(p);
			System.out.println(p);
			return profileRepository.getById(p.getId());
		}
}
