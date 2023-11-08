package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Manufacturers;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturers, Long>{
    Optional<Manufacturers> findByName(String name);
}
