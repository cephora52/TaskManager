package com.example.taskmanager.controllers;

import com.example.taskmanager.jwt.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestParam String email,
                                    @RequestParam String password){

        // normalement on vérifie dans la base
        // ici version simple

        String token = jwtUtils.generateToken(email);

        Map<String,String> response = new HashMap<>();

        response.put("token", token);

        return response;
    }
}