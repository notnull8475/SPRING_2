package ru.gb.springone.market.auth.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.db.springone.market.api.AppError;
import ru.db.springone.market.api.RegisterUserDto;
import ru.gb.springone.market.auth.entities.AppRole;
import ru.gb.springone.market.auth.entities.AppUser;
import ru.gb.springone.market.auth.repositories.AppUsersRepository;

import javax.management.relation.RoleNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUsersRepository usersRepository;
    private AppRoleService roleService;


    public Optional<AppUser> findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    @Transactional
    @org.springframework.transaction.annotation.Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }


    public void saveUser(AppUser appUser) {
        usersRepository.save(appUser);
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<AppRole> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public Page<AppUser> getUsers(int rows, int page) {
        Page<AppUser> userList = usersRepository.findAll(PageRequest.of(page, rows));
        System.out.println(userList);
        return userList;
    }

    public AppUser getUserById(Long id) {
        return usersRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Пользователь с id " + id + " не найден"));
    }

    public AppUser registrationUser(RegisterUserDto registerUserDto) {
        AppUser user = new AppUser();
        user.setUsername(registerUserDto.getUsername());
        user.setPassword(registerUserDto.getPassword());
        user.setRoles(Collections.singleton(roleService.getUserRole()));
        return usersRepository.save(user);
    }
}
