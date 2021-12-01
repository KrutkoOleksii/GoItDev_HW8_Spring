package ua.goit.hw8Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.service.ProducerServiceImpl;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "producer")
public class ProducerController {

    private final ProducerServiceImpl producerService;

    @RequestMapping(value = {"producers"}, method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("producers",producerService.findAll());
        return "producers";
    }

    @RequestMapping(value = {"find"}, method = RequestMethod.GET)
    public String findById(Model model, Long id) {
        model.addAttribute("producer", producerService.findById(id));
        return "producer";
    }

    @RequestMapping(value = {"findByName"}, method = RequestMethod.GET)
    public String openFindForm(Model model) {
        model.addAttribute("entity", Producer.class.getSimpleName());
        return "findByName";
    }

    @RequestMapping(value = {"findEntity"}, method = RequestMethod.GET)
    public String findByName(Model model, String name) {
        model.addAttribute("producer", producerService.findByName(name));
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
        model.addAttribute("producer", producerService.findById(id));
        return "saveProducer";
    }

    @RequestMapping(value = {"saveProducer"}, method = RequestMethod.POST)
    public String save(Model model, Producer producer){
        producerService.save(producer);
        return findAll(model);
    }

    @RequestMapping(value = {"saveProducer"}, method = RequestMethod.PUT)
    public String update(Model model, Producer producer){
        producerService.save(producer);
        return findAll(model);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String deleteById(Model model, Long id){
        producerService.deleteById(id);
        return findAll(model);
    }

}
