package ua.goit.hw8Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Role;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;
import ua.goit.hw8Spring.service.UserServiceImpl;

import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequiredArgsConstructor
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;

    @RequestMapping(value = {"users"}, method = RequestMethod.GET)
    public String viewUsers(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users",userList);
        return "users";
    }

    @RequestMapping(value = {"findByName"}, method = RequestMethod.GET)
    public String findByName(Model model) {
        model.addAttribute("entity", User.class.getSimpleName());
        return "findByName";
    }

    @RequestMapping(value = {"findEntity"}, method = RequestMethod.GET)
    public String findEntity(Model model, String name) {
        User user = userRepository.findByEmail(name).orElse(null);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = {"find"}, method = RequestMethod.GET)
    public String findById(Model model, Long id) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "user";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        model.addAttribute("roles",Role.values());
        return "saveUser";
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("user", userRepository.findById(id).get());
        return "saveUser";
    }

    @RequestMapping(value = {"saveUser"}, method = RequestMethod.POST)
    public String save(Model model, User user){
        userService.userRegistration(user);
        //User save = userRepository.save(user);
        return viewUsers(model);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String delete(Model model, Long id){
        userRepository.deleteById(id);
        return viewUsers(model);
    }

}
