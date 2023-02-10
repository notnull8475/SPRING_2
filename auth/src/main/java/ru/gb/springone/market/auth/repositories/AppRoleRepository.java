package ru.gb.springone.market.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.springone.market.auth.entities.AppRole;

import java.util.Optional;


@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    Optional<AppRole> findByRoleName(String roleName);
}
