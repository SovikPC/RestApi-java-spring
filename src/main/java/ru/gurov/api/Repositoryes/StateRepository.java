package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.State;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Long>{
    Optional<State> findByName(String name);
}
