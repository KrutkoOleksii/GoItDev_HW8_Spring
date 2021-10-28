package ua.goit.hw8Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.hw8Spring.model.Producer;

import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

    @Query("SELECT p FROM Producer p WHERE p.name=?1")
    Optional<Producer> findByName(String name);
}
