package com.personal.blog.services;

import com.personal.blog.model.UserModel;
import com.personal.blog.model.data.request.SignInRequest;
import com.personal.blog.model.data.request.SignupRequest;
import com.personal.blog.model.data.response.JwtAuthenticationResponse;
import com.personal.blog.model.data.response.RefreshTokenRequest;

public interface AuthenticationService {
    UserModel signUp(SignupRequest signupRequest);

    JwtAuthenticationResponse signIn(SignInRequest signupRequest);

    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}