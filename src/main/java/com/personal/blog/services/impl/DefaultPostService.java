package com.personal.blog.services.impl;

import com.personal.blog.model.PostModel;
import com.personal.blog.model.data.request.PostRequestDto;
import com.personal.blog.model.data.response.PostResponseDto;
import com.personal.blog.repository.PostRepository;
import com.personal.blog.services.PostService;
import com.personal.blog.utils.CurrentUser;
import com.personal.blog.utils.DateUtils;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPostService implements PostService {
    @Resource
    private PostRepository postRepository;

    @Override
    public List<PostResponseDto> getAllPosts() {
        List<PostModel> allPosts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return populatePosts(allPosts);
    }

    @Override
    public Boolean createPost(PostRequestDto postRequestDto) {
        PostModel post = PostModel.builder()
                .description(postRequestDto.getDescription())
                .title(postRequestDto.getTitle())
                .media(postRequestDto.getMedia())
                .category(postRequestDto.getCategory())
                .owner(CurrentUser.resolve())
                .creationTime(DateUtils.formatedCurrentDate())
                .modifiedTime(DateUtils.formatedCurrentDate())
                .build();
        postRepository.save(post);
        return Boolean.TRUE;
    }

    @Override
    public List<PostResponseDto> getPostByCategory(String category) {
        List<PostModel> byCategory = postRepository.findByCategory(category);
        return this.populatePosts(byCategory);
    }

    @Override
    public List<PostResponseDto> getPostByOwner() {
        List<PostModel> byOwner = postRepository.findByOwner(CurrentUser.resolve());
        return populatePosts(byOwner);
    }

    private  List<PostResponseDto> populatePosts(List<PostModel> postModels){
        List<PostResponseDto> result = new ArrayList<>();
        for (PostModel post : postModels) {
            PostResponseDto postResponseDto = PostResponseDto.builder()
                    .title(post.getTitle())
                    .media(post.getMedia())
                    .owner(post.getOwner())
                    .description(post.getDescription())
                    .creationTime(post.getCreationTime())
                    .modifiedTime(post.getModifiedTime())
                    .build();
            result.add(postResponseDto);
        }
        return result;
    }
}
