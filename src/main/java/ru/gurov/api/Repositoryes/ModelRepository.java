package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{}
