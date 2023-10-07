package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

}
