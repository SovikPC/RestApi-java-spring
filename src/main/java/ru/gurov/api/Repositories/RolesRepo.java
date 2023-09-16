package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Roles;

public interface RolesRepo extends JpaRepository<Roles, Long>{}
