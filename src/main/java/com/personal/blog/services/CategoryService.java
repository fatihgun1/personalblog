package com.personal.blog.services;

import com.personal.blog.model.data.request.CategoryRequestDto;
import com.personal.blog.model.data.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getCategories();
    CategoryResponseDto createCategory(CategoryRequestDto category);
}
