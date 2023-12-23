package ru.gurov.api.components.statuses;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.gurov.api.components.statuses.Status;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    Optional<Status> findByStatus(String name);
}
