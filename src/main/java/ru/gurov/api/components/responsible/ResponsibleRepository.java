package ru.gurov.api.components.responsible;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gurov.api.components.responsible.Responsible;

import java.util.Optional;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Integer> {
    Optional<Responsible> findByFull(String full_name);
}
