package com.personal.blog.model.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryRequestDto {
    private String name;
    private String url;
    private Boolean visible;
}
