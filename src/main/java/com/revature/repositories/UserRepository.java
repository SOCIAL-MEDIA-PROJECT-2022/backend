package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);
    


    Optional<User> findByEmail(String email);

    List<User> searchByEmail(String email);
    
   
    
    
 

    List<User> searchByEmail(String email);
    
    @Query("FROM users u WHERE u.email LIKE %:name%")
    List<User> findByEmailContains(@Param("email")String email);
    
    

}
