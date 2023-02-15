package ru.gb.springone.market.auth.utils;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.gb.springone.market.auth.entities.AppUser;
import ru.gb.springone.market.auth.repositories.AppRoleRepository;
import ru.gb.springone.market.auth.repositories.AppUsersRepository;

import java.util.Collections;
import java.util.Objects;
@Component
@RequiredArgsConstructor
public class DBRootUserFill {
    private final AppUsersRepository appUserRepository;
    private final AppRoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void fillDBonStart() {
        AppUser appUser = appUserRepository.findByUsername("root").orElse(null);
        if (Objects.isNull(appUser)) {
            System.out.println("ROOT USER ADD");
            appUser = AppUser.builder()
                    .username("root")
                    .password(passwordEncoder.encode("root"))
                    .roles(Collections.singleton(roleRepository.findByRoleName("ROOT").get()))
                    .build();
            appUserRepository.save(appUser);
        }
    }
}
