package com.alibou.security.auth;

import com.alibou.security.config.JwtService;
import com.alibou.security.user.Role;
import com.alibou.security.user.User;
import com.alibou.security.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .email(request.getEmail())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(  () -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(jwtToken)
                .build();
    }

    public TokenValidationResponse authenticate(HttpServletRequest request) {
        String token = extractTokenFromRequest(request);
        boolean isValid = jwtService.validateToken(token);

        if (isValid) {
            String email = jwtService.extractEmail(token);
            System.out.println("Extraction de l'email: " + email);
            String role = jwtService.extractRole(token);
            System.out.println("Extraction du role: " + role);
            return new TokenValidationResponse(true, email, role, token);
        } else {
            return new TokenValidationResponse(false, null, null, null);
        }
    }


    private String extractTokenFromRequest(HttpServletRequest request) {
        String token = null;
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
        }
        return token;
    }
}
