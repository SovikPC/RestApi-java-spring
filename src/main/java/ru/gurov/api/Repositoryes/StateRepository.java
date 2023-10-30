package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.States;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<States, Long>{
    Optional<States> findByName(String name);
}
