package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Logs;

@Repository
public interface LogRepository extends JpaRepository<Logs, Long> {
}
