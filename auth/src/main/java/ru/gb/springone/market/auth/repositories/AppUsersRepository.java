package ru.gb.springone.market.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.springone.market.auth.entities.AppUser;

import java.util.Optional;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

}
