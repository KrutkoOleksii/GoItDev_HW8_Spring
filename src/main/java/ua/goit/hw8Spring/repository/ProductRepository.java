package ua.goit.hw8Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.hw8Spring.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
