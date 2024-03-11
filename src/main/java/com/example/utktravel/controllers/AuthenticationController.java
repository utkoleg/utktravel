package com.example.utktravel.controllers;

import com.example.utktravel.dto.request.AuthenticationRequest;
import com.example.utktravel.dto.response.AuthenticationResponse;
import com.example.utktravel.auth.AuthenticationService;
import com.example.utktravel.dto.request.RegisterRequest;
import com.example.utktravel.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utktravel/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/activate")
    public String verifyUser(@RequestParam("token") String token) {
        return userService.activateUser(token);
    }

}
