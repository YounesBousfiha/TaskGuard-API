package com.taskguard.taskguard.interfaces;

import com.taskguard.taskguard.application.UserService;
import com.taskguard.taskguard.domain.model.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @Data
    public static class RegistrationRequest {
        private String username;
        private String email;
        private String password;
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthResponse {
        // Getters and setters
        private String token;
        private String username;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(
            @Valid @RequestBody RegistrationRequest registrationRequest
    ) {
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword());

        User registeredUser = userService.registerUser(user);

        String token = userService.authenticateUser(
                registeredUser.getUsername(),
                registrationRequest.getPassword()
        );

        return ResponseEntity.ok(new AuthResponse(token, registeredUser.getUsername()));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest loginRequest
    ) {
        String token = userService.authenticateUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        return ResponseEntity.ok(new AuthResponse(token, loginRequest.getUsername()));
    }
}