package ua.goit.hw8Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.hw8Spring.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
