package com.rodolfo.taskMaster.controller;


import com.rodolfo.taskMaster.dto.AuthResponse;
import com.rodolfo.taskMaster.dto.LoginRequest;
import com.rodolfo.taskMaster.dto.RegisterRequest;
import com.rodolfo.taskMaster.dto.UserResponse;
import com.rodolfo.taskMaster.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "Authentication Api")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String test() {
        return "Endpoint protegido funcionando";
    }

    @Operation(summary = "Register new user")
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){

        UserResponse response = authService.register(request);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
