package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Equipments;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipments, Long>{

}
