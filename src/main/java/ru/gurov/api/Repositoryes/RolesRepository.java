package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Roles;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long>{
    Optional<Roles> findByName(String name);
}
