package ru.gb.SpringOne.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.gb.SpringOne.models.AppRole;
import ru.gb.SpringOne.models.AppUser;
import ru.gb.SpringOne.repositories.AppUsersRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = usersRepository.findByUsername(username).orElseThrow();
        return User.builder()
                .username(username)
                .password(user.getPassword())
                .authorities(mapRolesToAuthorities(user.getRoles()))
                .build();
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
}
