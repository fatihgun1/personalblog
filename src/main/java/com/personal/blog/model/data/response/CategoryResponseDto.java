package com.personal.blog.model.data.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDto {
    private String name;
    private String url;
}
