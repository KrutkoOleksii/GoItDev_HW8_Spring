package ua.goit.hw8Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.model.Product;
import ua.goit.hw8Spring.service.ProducerServiceImpl;
import ua.goit.hw8Spring.service.ProductServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "product")
public class ProductController {

    private final ProductServiceImpl productService;
    private final ProducerServiceImpl producerService;

    @RequestMapping(value = {"products"}, method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "products";
    }

    @RequestMapping(value = {"findByName"}, method = RequestMethod.GET)
    public String findByName(Model model) {
        model.addAttribute("entity", Product.class.getSimpleName());
        return "findByName";
    }

    @RequestMapping(value = {"findEntity"}, method = RequestMethod.GET)
    public String findByName(Model model, String name) {
        Product product = productService.findByName(name);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = {"find"}, method = RequestMethod.GET)
    public String findById(Model model, Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        List<Producer> producers = producerService.findAll();
        model.addAttribute("producers",producers);
        return "saveProduct";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("product", productService.findById(id));
        return "saveProduct";
    }

    @RequestMapping(value = {"saveProduct"}, method = RequestMethod.POST)
    public String save(Model model, Product product){
        Product save = productService.save(product);
        return findAll(model);
    }

    @RequestMapping(value = {"saveProduct"}, method = RequestMethod.PUT)
    public String update(Model model, Product product){
        Product save = productService.save(product);
        return findAll(model);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String deleteById(Model model, Long id){
        productService.deleteById(id);
        return findAll(model);
    }

}
