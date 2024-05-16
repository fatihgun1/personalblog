package com.personal.blog.controller;

import com.personal.blog.model.UserModel;
import com.personal.blog.model.data.request.SignInRequest;
import com.personal.blog.model.data.request.SignupRequest;
import com.personal.blog.model.data.response.JwtAuthenticationResponse;
import com.personal.blog.model.data.response.RefreshTokenRequest;
import com.personal.blog.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired(required = true)
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authenticationService.signUp(signupRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }

}