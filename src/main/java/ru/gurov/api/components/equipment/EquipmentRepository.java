package ru.gurov.api.components.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.components.equipment.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{

}
