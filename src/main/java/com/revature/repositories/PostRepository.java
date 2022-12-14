package com.revature.repositories;

import com.revature.models.Post;
import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByComment(boolean b);

    Optional<Post> findById(int id); // post id not user id

    Optional<List<Post>> findPostsByAuthor(User u);

    Optional<List<Post>> findAllByTextNotNull();
}
