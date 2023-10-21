package ru.gurov.api.Repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gurov.api.Models.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> getByLogin(String login);

    Boolean existsByLogin(String login);
}
