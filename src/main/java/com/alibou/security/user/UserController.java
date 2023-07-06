package com.alibou.security.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class UserController {

    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
    @GetMapping
    public ResponseEntity<UserResponse> get() {
        return ResponseEntity.ok(UserResponse.builder()
                .message("User only :: Hello User from get method")
                .result(true)
                .data("User only :: Hello User from get method")
                .build());
    }
    @PostMapping
    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
    public ResponseEntity<UserResponse> post() {
        return ResponseEntity.ok(UserResponse.builder()
                .message("User only :: Hello User from post method")
                .result(true)
                .data("User only :: Hello User from post method")
                .build());
    }
    @PutMapping
    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
    public ResponseEntity<UserResponse> put() {
        return ResponseEntity.ok(UserResponse.builder()
                .message("User only :: Hello User from put method")
                .result(true)
                .data("User only :: Hello User from put method")
                .build());
    }
    @DeleteMapping
    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
    public ResponseEntity<UserResponse> delete() {
        return ResponseEntity.ok(UserResponse.builder()
                .message("User only :: Hello User from delete method")
                .result(true)
                .data("User only :: Hello User from delete method")
                .build());
    }
    @PatchMapping
    @CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
    public ResponseEntity<UserResponse> patch() {
        return ResponseEntity.ok(UserResponse.builder()
                .message("User only :: Hello User from patch method")
                .result(true)
                .data("User only :: Hello User from patch method")
                .build());
    }
}
