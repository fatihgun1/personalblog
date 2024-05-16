package com.personal.blog.controller;

import com.personal.blog.model.data.request.CategoryRequestDto;
import com.personal.blog.model.data.response.CategoryResponseDto;
import com.personal.blog.services.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return ResponseEntity.ok(categoryService.createCategory(categoryRequestDto));
    }

}
