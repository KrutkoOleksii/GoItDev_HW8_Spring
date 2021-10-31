package ua.goit.hw8Spring.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.model.Product;
import ua.goit.hw8Spring.repository.ProducerRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Controller
@RequestMapping(value = "producer")
public class ProducerController {

    private final ProducerRepository producerRepository;

    @RequestMapping(value = {"producers"}, method = RequestMethod.GET)
    public String viewProducers(Model model) {
        List<Producer> producerList = producerRepository.findAll();
        model.addAttribute("producers",producerList);
        return "producers";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        return "saveProducer";
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("producer", producerRepository.findById(id).get());
        return "saveProducer";
    }

    @RequestMapping(value = {"saveProducer"}, method = RequestMethod.POST)
    public String save(Model model){
        Producer producer = Producer.builder()
                .name(model.getAttribute("name").toString())
                .build();
        Producer save = producerRepository.save(producer);
        List<Producer> producerList = producerRepository.findAll();
        model.addAttribute("producers",producerList);
        return "producers";
    }

//    //@RolesAllowed({"ADMIN","USER"})
//    @GetMapping(value = "all")
//    public List<Producer> findAll() {
//        return producerRepository.findAll();
//    }
//    //@RolesAllowed({"ADMIN","USER"})
//    @GetMapping({"/{id}","/"})
//    public Optional<Producer> findById(@PathVariable(required = false, name = "id") Optional<Long> id) {
//        return id.map(producerRepository::findById).orElse(null);
//    }
//    //@RolesAllowed({"ADMIN"})
//    @PostMapping
//    public Producer save(@RequestBody Producer producer){
//        return producerRepository.save(producer);
//    }
//    //@RolesAllowed({"ADMIN"})
//    @PutMapping("name")
//    public Producer changeName(@ApiParam(required = true) @RequestParam(name = "id") Long id, @RequestParam(name = "name") String name){
//        return producerRepository.findById(id)
//                .map(producer -> {producer.setName(name);
//                return producerRepository.save(producer);
//                })
//                .orElse(null);
//    }
//    //@RolesAllowed({"ADMIN"})
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable(name = "id") Long id) {
//        producerRepository.deleteById(id);
//    }
//    //@RolesAllowed({"ADMIN","USER"})
//    @GetMapping("/name/{name}")
//    public Optional<Producer> findByName(@PathVariable(name="name") String name) {
//        return producerRepository.findByName(name);
//    }

}
