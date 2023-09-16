package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Users;

public interface UsersRepo extends JpaRepository<Users, Long>{}
