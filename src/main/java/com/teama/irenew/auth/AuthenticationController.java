package com.teama.irenew.auth;

import com.teama.irenew.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserRepository repository;
    private final AuthenticationService service;

    @PostMapping("/register")

        if(repository.findByEmail(request.getEmail()).isPresent())

    {
        return ResponseEntity.badRequest().body("User email exists");
    }


    ///////////having duplicates causes a 403/////////////
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
    if(repository.findByEmail(request.getEmail()).isPresent()){
        return ResponseEntity.badRequest().body( "User email exists");
    }
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
