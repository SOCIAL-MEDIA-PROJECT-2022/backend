package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findById(int id);

    Optional<User> findByEmail(String email);

    List<User> findByEmailContainingIgnoreCase(String s);
    List<User> searchByEmail(String email);

}
