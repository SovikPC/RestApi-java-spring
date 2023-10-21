package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Position;

import java.util.Optional;

public interface PositionRepository extends JpaRepository<Position, Long>{
    Optional<Position> findByName(String name);
}
