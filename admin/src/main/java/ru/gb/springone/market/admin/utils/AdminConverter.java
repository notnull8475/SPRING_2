package ru.gb.springone.market.admin.utils;

import ru.db.springone.market.api.AppUserDto;
import ru.gb.springone.market.admin.entities.AppUser;

public class AdminConverter {
    public AppUserDto appUserToDto(AppUser appUser) {
        AppUserDto userDto = new AppUserDto();
        userDto.setId(appUser.getId());
        userDto.setEmail(appUser.getEmail());
        userDto.setUsername(appUser.getUsername());
        userDto.setFirstname(appUser.getFirstname());
        userDto.setLastname(appUser.getLastname());
        userDto.setEnabled(appUser.isEnabled());
        return userDto;

    }

    public AppUser dtoToAppUser(AppUserDto appUserDto) {
        return AppUser.builder()
                .id(appUserDto.getId())
                .email(appUserDto.getEmail())
                .username(appUserDto.getUsername())
                .firstname(appUserDto.getFirstname())
                .lastname(appUserDto.getLastname())
                .enabled(appUserDto.isEnabled())
                .build();
    }
}
