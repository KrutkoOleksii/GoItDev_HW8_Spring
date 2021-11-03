package ua.goit.hw8Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.hw8Spring.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT p FROM User p WHERE p.email=?1")
    Optional<User> findByEmail(String email);

}
