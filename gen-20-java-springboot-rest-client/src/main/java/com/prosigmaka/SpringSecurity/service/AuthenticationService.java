package com.prosigmaka.SpringSecurity.service;

import com.prosigmaka.SpringSecurity.model.AuthenticationRequestModel;
import com.prosigmaka.SpringSecurity.model.AuthenticationResponseModel;
import com.prosigmaka.SpringSecurity.model.RegisterRequestModel;
import com.prosigmaka.SpringSecurity.entity.UserEntity;
import com.prosigmaka.SpringSecurity.helper.Role;
import com.prosigmaka.SpringSecurity.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponseModel register(RegisterRequestModel request){
        var user = UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .userDate(request.getUserDate())
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseModel.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseModel authentication(AuthenticationRequestModel request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponseModel.builder()
                .token(jwtToken)
                .build();
    }
}
