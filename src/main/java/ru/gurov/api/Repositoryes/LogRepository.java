package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gurov.api.Models.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
}
