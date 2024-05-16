package com.personal.blog.model.data.request;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String description;
    private String media;
    private String category;
}
