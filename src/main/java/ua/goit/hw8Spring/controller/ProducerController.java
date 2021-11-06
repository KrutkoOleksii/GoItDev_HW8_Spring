package ua.goit.hw8Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.repository.ProducerRepository;

import javax.annotation.security.RolesAllowed;
import java.util.List;

//@EnableWebSecurity
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

    @RequestMapping(value = {"find"}, method = RequestMethod.GET)
    public String findById(Model model, Long id) {
        Producer producer = producerRepository.findById(id).orElse(null);
        model.addAttribute("producer", producer);
        return "producer";
    }

    @RequestMapping(value = {"findByName"}, method = RequestMethod.GET)
    public String findByName(Model model) {
        model.addAttribute("entity", Producer.class.getSimpleName());
        return "findByName";
    }

    @RequestMapping(value = {"findEntity"}, method = RequestMethod.GET)
    public String findEntity(Model model, String name) {
        Producer producer = producerRepository.findByName(name).orElse(null);
        model.addAttribute("producer", producer);
        return "producer";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        return "saveProducer";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("producer", producerRepository.findById(id).get());
        return "saveProducer";
    }

    @RolesAllowed("ADMIN")
    @RequestMapping(value = {"saveProducer"}, method = RequestMethod.POST)
    public String save(Model model, Producer producer){
        Producer save = producerRepository.save(producer);
        return viewProducers(model);
    }

    @RolesAllowed("ADMIN")
    @RequestMapping(value = {"saveProducer"}, method = RequestMethod.PUT)
    public String update(Model model, Producer producer){
        Producer save = producerRepository.save(producer);
        return viewProducers(model);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String delete(Model model, Long id){
        producerRepository.deleteById(id);
        return viewProducers(model);
    }

}
