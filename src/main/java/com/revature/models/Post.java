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
	@OneToMany(cascade = CascadeType.ALL)
	private List<Post> comments;
	@ManyToOne
	private User author;

	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name = "likes",
			joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "email" /*, referencedColumnName = "email"*/)
	)
	//Inverse column makes a fuss when I try to label it as userId
	//Additionally inverse column makes a fuss when we try to reference the appropriate column
	public List<User> likes;
}
