package com.personal.blog.model.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostResponseDto {
    private String title;
    private String description;
    private String media;
    private String owner;
    private String creationTime;
    private String modifiedTime;

}
