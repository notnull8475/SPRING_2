package ru.gb.springone.market.admin.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.db.springone.market.api.AppUserDto;
import ru.gb.springone.market.admin.services.AppUserService;
import ru.gb.springone.market.admin.utils.AdminConverter;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AdminConverter converter;
    private final AppUserService userService;


    @GetMapping
    public Page<AppUserDto> getUsers(@RequestParam(name = "rows", required = false, defaultValue = "5") int rows,
                                     @RequestParam(name = "page", required = false, defaultValue = "1") int page) {
        if (rows < 0) rows = 5;
        if (page < 0) page = 1;
        return userService.getUsers(rows, page - 1).map(converter::appUserToDto);
    }

    @GetMapping("/{id}")
    public AppUserDto getUser(@PathVariable Long id) {
        return converter.appUserToDto(userService.getUserById(id));
    }
}
