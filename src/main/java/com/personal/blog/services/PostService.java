package com.personal.blog.services;

import com.personal.blog.model.data.request.PostRequestDto;
import com.personal.blog.model.data.response.PostResponseDto;

import java.util.List;

public interface PostService {

    List<PostResponseDto> getAllPosts();
    Boolean createPost(PostRequestDto postRequestDto);
    List<PostResponseDto> getPostByCategory(String category);
    List<PostResponseDto> getPostByOwner();
}
