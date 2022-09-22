package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
@Setter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userId;
    private String aboutMe;
    private String hobbies;
    private String somethingElse;
    private String profilePic;
}





