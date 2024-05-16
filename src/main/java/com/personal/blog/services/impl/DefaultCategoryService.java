package com.personal.blog.services.impl;

import com.personal.blog.model.CategoryModel;
import com.personal.blog.model.data.request.CategoryRequestDto;
import com.personal.blog.model.data.response.CategoryResponseDto;
import com.personal.blog.repository.CategoryRepository;
import com.personal.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> getCategories() {
        List<CategoryResponseDto> categories = new ArrayList<>();
        for (CategoryModel categoryModel : categoryRepository.findByVisible(Boolean.TRUE)) {
            CategoryResponseDto categoryResponse = CategoryResponseDto.builder()
                    .name(categoryModel.getName())
                    .url(categoryModel.getUrl())
                    .build();
            categories.add(categoryResponse);
        }
        return categories;
    }


    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto category) {

        CategoryModel categoryModel = CategoryModel.builder()
                .name(category.getName())
                .url(category.getUrl())
                .visible(category.getVisible())
                .build();

        CategoryModel savedModel = categoryRepository.save(categoryModel);

        return CategoryResponseDto.builder()
                .name(savedModel.getName())
                .url(savedModel.getUrl())
                .build();
    }
}
