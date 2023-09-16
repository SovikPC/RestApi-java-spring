package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Position;

public interface PositionRepo extends JpaRepository<Position, Long>{}
