package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Models;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Models, Long>{
    Optional<Models> findByName(String name);
}
