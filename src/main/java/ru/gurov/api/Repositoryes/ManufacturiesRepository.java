package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Manufacturies;

import java.util.Optional;

public interface ManufacturiesRepository extends JpaRepository<Manufacturies, Long>{
    Optional<Manufacturies> findByName(String name);
}
