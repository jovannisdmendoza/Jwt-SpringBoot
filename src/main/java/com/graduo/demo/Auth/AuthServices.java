package com.graduo.demo.Auth;

import org.springframework.stereotype.Service;

import com.graduo.demo.User.Role;
import com.graduo.demo.User.User;
import com.graduo.demo.User.UserRepository;
import com.graduo.demo.jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServices {

    private final UserRepository userrepository;
    private final JwtService jwtService;
    public AuthResponse login(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .firstname(request.getFisrtname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        userrepository.save(user);

        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }


}
