package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.ERoles;
import ru.gurov.api.Models.Roles;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long>{
    Optional<Roles> findByName(ERoles name);
}