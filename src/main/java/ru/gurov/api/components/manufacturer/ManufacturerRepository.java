package ru.gurov.api.components.manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.components.manufacturer.Manufacturer;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer>{
    Optional<Manufacturer> findByName(String name);
}
