package ru.gurov.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Reports;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Long> {
//    Optional<Reports> findByUser_id(Long id);
}
