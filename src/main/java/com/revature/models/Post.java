package com.revature.models;

import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String text;
	private String imageUrl;
	//need to change the 2nd record of likes to accept strings to insert emails
	@OneToMany
	List<User> likes;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> comments;
	@ManyToOne
	private User author;
}
