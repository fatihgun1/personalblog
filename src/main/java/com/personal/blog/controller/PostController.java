package com.personal.blog.controller;

import com.personal.blog.model.data.request.PostRequestDto;
import com.personal.blog.model.data.response.PostResponseDto;
import com.personal.blog.services.PostService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping("/all")
    public ResponseEntity<List<PostResponseDto>> getPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/create")
    public ResponseEntity<Boolean> createPost(@RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok(postService.createPost(requestDto));
    }
    @GetMapping("/category")
    public ResponseEntity<List<PostResponseDto>> getPostByCategory(@RequestParam(name = "name",required = true) String category) {
        return ResponseEntity.ok(postService.getPostByCategory(category));
    }
    @GetMapping("/user")
    public ResponseEntity<List<PostResponseDto>> getPostByOwner() {
        return ResponseEntity.ok(postService.getPostByOwner());
    }

}
