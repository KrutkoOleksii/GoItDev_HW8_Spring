package ua.goit.hw8Spring.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.model.Product;
import ua.goit.hw8Spring.repository.ProducerRepository;
import ua.goit.hw8Spring.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProducerRepository producerRepository;

    @RequestMapping(value = {"products"}, method = RequestMethod.GET)
    public String viewProducts(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("products",productList);
        return "products";
    }
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        List<Producer> producers = producerRepository.findAll();
        model.addAttribute("producers",producers);
        return "saveProduct";
    }
//    @GetMapping(value = "all")
//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }
//
//    @GetMapping({"/{id}","/"})
//    public Optional<Product> findById(@PathVariable(required = false, name = "id") Optional<Long> id) {
//        return id.map(productRepository::findById).orElse(null);
//    }
//
//    @PutMapping("name")
//    public Product changeName(@ApiParam(required = true) @RequestParam(name = "id") Long id, @RequestParam(name = "name") String name){
//        return productRepository.findById(id)
//                .map(producer -> {producer.setName(name);
//                    return productRepository.save(producer);
//                })
//                .orElse(null);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable(name = "id") Long id) {
//        productRepository.deleteById(id);
//    }

//    @GetMapping("/name/{name}")
//    public Optional<Product> findByName(@PathVariable(name="name") String name) {
//        return productRepository.findByName(name);
//    }

}
