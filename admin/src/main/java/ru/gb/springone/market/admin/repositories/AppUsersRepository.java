package ru.gb.springone.market.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.springone.market.admin.entities.AppUser;

import java.util.Optional;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);

}
