package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Model;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long>{
    Optional<Model> findByName(String name);
}
