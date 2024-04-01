package com.prosigmaka.SpringSecurity.controller;

import com.prosigmaka.SpringSecurity.helper.GlobalHttpResponse;
import com.prosigmaka.SpringSecurity.service.AuthenticationRequest;
import com.prosigmaka.SpringSecurity.service.AuthenticationResponse;
import com.prosigmaka.SpringSecurity.service.AuthenticationService;
import com.prosigmaka.SpringSecurity.service.RegisterRequest;
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
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authresponse(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authentication(request));
    }
}
