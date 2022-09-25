package com.revature.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {
    private int id;
    private int userId;
    private String aboutMe;
    private String hobbies;
    private String somethingElse;
    private String profilePic;
}
