package ru.gb.springone.market.auth.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springone.market.auth.entities.AppRole;
import ru.gb.springone.market.auth.repositories.AppRoleRepository;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppRoleService {
    private final AppRoleRepository roleRepository;

    public Optional<AppRole> getByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public List<AppRole> getRoles() {
        return roleRepository.findAll();
    }

    public AppRole getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public AppRole getUserRole(){
        return roleRepository.findByName("USER").get();
    }
}
