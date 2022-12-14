package com.revature.services;


import com.revature.dtos.SearchReturn;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SearchService {

    private final UserRepository userRepository;

    public SearchService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<SearchReturn> search(String s) {

        List<User> userList = userRepository.findByEmailContainingIgnoreCase(s);

        List<SearchReturn> matchingUser = new LinkedList<>();
        for (User u : userList) {
            matchingUser.add(new SearchReturn(u.getId(), u.getEmail(), u.getFirstName(), u.getLastName()));
        }
        return matchingUser;

    }
}
