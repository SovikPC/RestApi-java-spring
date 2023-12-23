package ru.gurov.api.components.model;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.components.model.Model;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer>{
    Optional<Model> findByName(String name);
}
