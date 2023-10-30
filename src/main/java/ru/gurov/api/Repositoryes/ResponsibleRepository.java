package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Responsible_persons;

import java.util.Optional;
@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible_persons, Long>{
    Optional<Responsible_persons> findByFio(String fio);
}
