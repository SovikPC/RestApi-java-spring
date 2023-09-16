package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.State;

public interface StateRepo extends JpaRepository<State, Long>{}
