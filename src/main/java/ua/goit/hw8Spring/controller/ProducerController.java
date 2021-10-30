package ua.goit.hw8Spring.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.repository.ProducerRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "producer")
public class ProducerController {

    private final ProducerRepository producerRepository;

    //@RolesAllowed({"ADMIN","USER"})
    @GetMapping(value = "all")
    public List<Producer> findAll() {
        return producerRepository.findAll();
    }

    //@RolesAllowed({"ADMIN","USER"})
    @GetMapping({"/{id}","/"})
    public Optional<Producer> findById(@PathVariable(required = false, name = "id") Optional<Long> id) {
        return id.map(producerRepository::findById).orElse(null);
    }

    //@RolesAllowed({"ADMIN"})
    @PostMapping
    public Producer save(@RequestBody Producer producer){
        return producerRepository.save(producer);
    }

    //@RolesAllowed({"ADMIN"})
    @PutMapping("name")
    public Producer changeName(@ApiParam(required = true) @RequestParam(name = "id") Long id, @RequestParam(name = "name") String name){
        return producerRepository.findById(id)
                .map(producer -> {producer.setName(name);
                return producerRepository.save(producer);
                })
                .orElse(null);
    }

    //@RolesAllowed({"ADMIN"})
    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        producerRepository.deleteById(id);
    }

    //@RolesAllowed({"ADMIN","USER"})
    @GetMapping("/name/{name}")
    public Optional<Producer> findByName(@PathVariable(name="name") String name) {
        return producerRepository.findByName(name);
    }

}
