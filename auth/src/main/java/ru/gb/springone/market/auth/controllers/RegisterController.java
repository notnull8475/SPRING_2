package ru.gb.springone.market.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.db.springone.market.api.AppError;
import ru.db.springone.market.api.JwtResponse;
import ru.db.springone.market.api.RegisterUserDto;
import ru.gb.springone.market.auth.services.AppUserService;
import ru.gb.springone.market.auth.utils.JwtTokenUtil;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;


    @PostMapping("/api/v1/registration")
    public ResponseEntity<?> registerNewUser(@RequestBody RegisterUserDto registerUserDto) {
        if (appUserService.findByUsername(registerUserDto.getUsername()).isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Логин занят"), HttpStatus.BAD_REQUEST);
        }

        if (Objects.nonNull(appUserService.registrationUser(registerUserDto))) {

            UserDetails userDetails = appUserService.loadUserByUsername(registerUserDto.getUsername());
            String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponse(token));
        }
        return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Ошибка регистрации"), HttpStatus.BAD_REQUEST);
        // TODO полностью реализовать метод, как считаете нужным
        //  ниже всего лишь пример хеширования паролей
    }
}
