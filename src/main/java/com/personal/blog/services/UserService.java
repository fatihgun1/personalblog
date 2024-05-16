package com.personal.blog.services;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService getUserDetailsService();
}