package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{}
