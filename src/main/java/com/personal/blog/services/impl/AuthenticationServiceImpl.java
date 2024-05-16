package com.personal.blog.services.impl;

import com.personal.blog.model.UserModel;
import com.personal.blog.model.data.request.SignInRequest;
import com.personal.blog.model.data.request.SignupRequest;
import com.personal.blog.model.data.response.JwtAuthenticationResponse;
import com.personal.blog.model.data.response.RefreshTokenRequest;
import com.personal.blog.model.enumtype.RoleEnum;
import com.personal.blog.repository.UserRepository;
import com.personal.blog.services.AuthenticationService;
import com.personal.blog.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public UserModel signUp(SignupRequest signupRequest){
        UserModel user = new UserModel();
        user.setEmail(signupRequest.getEmail());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setRoles(RoleEnum.USER);
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);
        return user;
    }


    @Override
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));
        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt =jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(),user);
        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setToken(jwt);
        response.setRefreshToken(refreshToken);

        return response;
    }

    @Override
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
        UserModel user = userRepository.findByEmail(userEmail).orElseThrow();
        if (jwtService.isTokenValid(refreshTokenRequest.getToken(),user)){
            var jwt = jwtService.generateToken(user);
            JwtAuthenticationResponse response = new JwtAuthenticationResponse();
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            return response;
        }
        return null;
    }
}