package ua.goit.hw8Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ua.goit.hw8Spring.model.Product;
import ua.goit.hw8Spring.repository.ProducerRepository;
import ua.goit.hw8Spring.repository.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements BaseService<Product,Long>{

    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;

    public List<Product> findAll() {
        return  productRepository.findAll();
    }

    public Product findByName(String name) {
        return productRepository.findByName(name).orElse(null);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
