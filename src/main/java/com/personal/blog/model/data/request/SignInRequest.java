package com.personal.blog.model.data.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}