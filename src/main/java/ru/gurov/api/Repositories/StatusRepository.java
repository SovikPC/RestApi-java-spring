package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Statuses;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Statuses, Long>{
    Optional<Statuses> findByStatus(String name);
}
