package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.State;

public interface StateRepository extends JpaRepository<State, Long>{}
