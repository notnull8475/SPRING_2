package ru.gb.SpringOne.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringOne.dto.AppUserDto;
import ru.gb.SpringOne.models.AppRole;
import ru.gb.SpringOne.services.AppRoleService;
import ru.gb.SpringOne.services.AppUserService;
import ru.gb.SpringOne.utils.Converter;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class AppRoleController {
    private final AppRoleService roleService;


    @GetMapping
    public List<AppRole> getUsers() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public AppRole getUser(@PathVariable Long id){
        return roleService.getRoleById(id);
    }
}
