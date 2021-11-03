package ua.goit.hw8Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.hw8Spring.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.name=?1")
    Optional<Product> findByName(String name);

}
