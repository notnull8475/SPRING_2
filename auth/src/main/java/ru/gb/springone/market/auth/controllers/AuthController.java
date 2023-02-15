package ru.gb.springone.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.db.springone.market.api.AppError;
import ru.db.springone.market.api.JwtRequest;
import ru.db.springone.market.api.JwtResponse;
import ru.gb.springone.market.auth.integrations.CartServiceIntegration;
import ru.gb.springone.market.auth.services.AppUserService;
import ru.gb.springone.market.auth.utils.JwtTokenUtil;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AppUserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final CartServiceIntegration integration;

    @PostMapping("/api/v1/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Incorrect username or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
//        integration.mergeCarts(authRequest.getUsername(),authRequest.getUUID());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
