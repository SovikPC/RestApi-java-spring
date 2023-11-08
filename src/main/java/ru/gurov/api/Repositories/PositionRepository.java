package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Positions;

import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Positions, Long>{
    Optional<Positions> findByName(String name);
}
