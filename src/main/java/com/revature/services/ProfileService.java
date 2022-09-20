package com.revature.services;



import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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


		public List<Profile> getAll() {
			// TODO Auto-generated method stub
			return this.profileRepository.findAll();
		}
		
		public List<Profile> getById(int id){
			
			List<Profile> profileList = profileRepository.findAll();
			
			List<Profile> matchingProfile = new LinkedList<>();
			
			for(Profile p: profileList) {
				if(p.getUser().getId() == id) {
					matchingProfile.add(p);
				}
				
			}
			
			return matchingProfile;
		}
}
