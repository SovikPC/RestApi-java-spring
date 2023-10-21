package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gurov.api.Models.Responsible;

import java.util.Optional;

public interface ResponsibleRepository extends JpaRepository<Responsible, Long>{
    Optional<Responsible> findByFio(String fio);
}
