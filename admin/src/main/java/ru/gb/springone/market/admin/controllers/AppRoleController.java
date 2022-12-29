package ru.gb.springone.market.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.SpringOne.models.AppRole;
import ru.gb.SpringOne.services.AppRoleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class AppRoleController {
    private final AppRoleService roleService;


    @GetMapping
    public List<AppRole> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/{id}")
    public AppRole getRole(@PathVariable Long id){
        return roleService.getRoleById(id);
    }
}
