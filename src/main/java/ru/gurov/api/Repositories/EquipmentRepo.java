package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Equipment;

public interface EquipmentRepo extends JpaRepository<Equipment, Long>{}
