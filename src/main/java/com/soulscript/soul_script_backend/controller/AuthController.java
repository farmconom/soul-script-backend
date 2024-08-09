package com.soulscript.soul_script_backend.controller;

import com.soulscript.soul_script_backend.config.JwtUtil;
import com.soulscript.soul_script_backend.dto.JwtDto;
import com.soulscript.soul_script_backend.dto.SingInRequestDto;
import com.soulscript.soul_script_backend.dto.UserDto;
import com.soulscript.soul_script_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto saveUser = userService.createUser(userDto);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@RequestBody SingInRequestDto signInRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword())
            );

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String jwt = jwtUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtDto(jwt).getToken());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
