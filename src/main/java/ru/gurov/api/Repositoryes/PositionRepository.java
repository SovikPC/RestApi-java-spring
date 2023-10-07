package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Position;

public interface PositionRepository extends JpaRepository<Position, Long>{}
