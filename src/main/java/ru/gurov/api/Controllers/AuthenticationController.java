package ru.gurov.api.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gurov.api.payload.AuthenticationRequest;
import ru.gurov.api.payload.AuthenticationResponse;
import ru.gurov.api.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "http://localhost:2000", allowedHeaders = "*")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
