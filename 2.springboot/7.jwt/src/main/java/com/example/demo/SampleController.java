package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jwt.JWTTokenProvider;


@RestController
public class SampleController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTTokenProvider tokenProvider;
    
    @Autowired
    UserDetailsService userDetailsService;
    
    @PostMapping("/api/auth/sign_in")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(Map.of("accessToken", jwt, "tokenType", "Bearer"));
    }
    
    @RequestMapping("/api/test")
    public ResponseEntity<?> testApi() {
        return ResponseEntity.ok(Map.of("message", "Hello"));
    }
}
