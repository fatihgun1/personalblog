package com.personal.blog.repository;

import com.personal.blog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM posts as p where p.category = :categoryName")
    List<PostModel> findByCategory(@Param("categoryName") String category);
    List<PostModel> findByOwner(String owner);
}
