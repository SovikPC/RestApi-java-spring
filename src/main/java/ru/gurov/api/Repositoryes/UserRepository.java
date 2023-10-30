package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gurov.api.Models.Users;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByLogin(String login);
}
