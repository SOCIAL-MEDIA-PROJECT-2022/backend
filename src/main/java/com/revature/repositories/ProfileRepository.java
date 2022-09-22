package com.revature.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Profile;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    
} 

