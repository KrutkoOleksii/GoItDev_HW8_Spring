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

    @RequestMapping(value = {"findByName"}, method = RequestMethod.GET)
    public String findByName(Model model) {
        model.addAttribute("entity", Product.class.getSimpleName());
        return "findByName";
    }

    @RequestMapping(value = {"findEntity"}, method = RequestMethod.GET)
    public String findEntity(Model model, String name) {
        Product product = productRepository.findByName(name).orElse(null);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = {"find"}, method = RequestMethod.GET)
    public String findById(Model model, Long id) {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        List<Producer> producers = producerRepository.findAll();
        model.addAttribute("producers",producers);
        return "saveProduct";
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("product", productRepository.findById(id).get());
        return "saveProduct";
    }

    @RequestMapping(value = {"saveProduct"}, method = RequestMethod.POST)
    public String save(Model model, Product product){
        Product save = productRepository.save(product);
        return viewProducts(model);
    }

    @RequestMapping(value = {"saveProduct"}, method = RequestMethod.PUT)
    public String update(Model model, Product product){
        Product save = productRepository.save(product);
        return viewProducts(model);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String delete(Model model, Long id){
        productRepository.deleteById(id);
        return viewProducts(model);
    }

}
