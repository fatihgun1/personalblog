package com.personal.blog.repository;

import com.personal.blog.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel,Long> {

    List<CategoryModel> findByVisible(Boolean visible);
}
