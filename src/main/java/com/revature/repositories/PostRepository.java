package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer>{
    Optional<Post> findById(int id);

}
