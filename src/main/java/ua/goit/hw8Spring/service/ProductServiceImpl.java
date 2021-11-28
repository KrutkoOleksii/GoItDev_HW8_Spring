package ua.goit.hw8Spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.hw8Spring.model.Product;
import ua.goit.hw8Spring.repository.ProducerRepository;
import ua.goit.hw8Spring.repository.ProductRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements BaseService<Product,Long>{

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
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
