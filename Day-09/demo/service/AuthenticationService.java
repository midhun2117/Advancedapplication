package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Request.AuthenticationRequest;
import com.example.demo.dto.Request.RegisterRequest;
import com.example.demo.dto.Response.AuthenticationResponse;
import com.example.demo.entity.UserRegister;
import com.example.demo.entity.enumerate.Role;
import com.example.demo.repository.UserRegisterRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	@Autowired
    private  UserRegisterRepository userRegisterRepository;
    private  PasswordEncoder passwordEncoder;
    private  JwtService jwtService;
    private  AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
    
		Role role;
		if (request.getRoles() != null) {
			role = request.getRoles();
		} else {
			role = Role.USER;
		}
        UserRegister user = UserRegister.builder()
                .username(request.getUsername())
                .emailid(request.getEmailid())
                .mobileno(request.getMobileno())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(role)
                .build();

        userRegisterRepository.save(user);

        String jwtToken = jwtService.generateToken(request.getUsername());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String jwtToken = jwtService.generateToken(request.getUsername());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
