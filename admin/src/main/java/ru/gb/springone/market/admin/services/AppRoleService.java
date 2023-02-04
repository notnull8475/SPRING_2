package ru.gb.springone.market.admin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springone.market.admin.entities.AppRole;
import ru.gb.springone.market.admin.repositories.AppRoleRepository;


import javax.management.relation.RoleNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppRoleService {
    private final AppRoleRepository roleRepository;

    AppRole getByName(String roleName) throws RoleNotFoundException {
        return roleRepository.findByName(roleName).orElseThrow(() -> new RoleNotFoundException());
    }

    public List<AppRole> getRoles() {
        return roleRepository.findAll();
    }

    public AppRole getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
