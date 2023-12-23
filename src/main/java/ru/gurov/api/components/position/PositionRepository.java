package ru.gurov.api.components.position;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.components.position.Position;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer>{
    Optional<Position> findByName(String name);
}
