package com.prosigmaka.SpringSecurity.controller;

import com.prosigmaka.SpringSecurity.model.AuthenticationRequestModel;
import com.prosigmaka.SpringSecurity.model.AuthenticationResponseModel;
import com.prosigmaka.SpringSecurity.service.AuthenticationService;
import com.prosigmaka.SpringSecurity.model.RegisterRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseModel> register(
            @RequestBody RegisterRequestModel request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponseModel> authresponse(
            @RequestBody AuthenticationRequestModel request
    ){
        return ResponseEntity.ok(authenticationService.authentication(request));
    }
}
