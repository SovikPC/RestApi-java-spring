package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{}
