package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Model;

public interface ModelRepo extends JpaRepository<Model, Long>{}
