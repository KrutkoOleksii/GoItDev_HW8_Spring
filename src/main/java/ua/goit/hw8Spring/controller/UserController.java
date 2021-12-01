package ua.goit.hw8Spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Role;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.service.UserServiceImpl;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterUser() {
        return "registerUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"users"}, method = RequestMethod.GET)
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"findByName"}, method = RequestMethod.GET)
    public String findByName(Model model) {
        model.addAttribute("entity", User.class.getSimpleName());
        return "findByName";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"findEntity"}, method = RequestMethod.GET)
    public String findEntity(Model model, String name) {
        model.addAttribute("user", userService.findByEmail(name));
        return "user";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"find"}, method = RequestMethod.GET)
    public String findById(Model model, Long id) {
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        model.addAttribute("roles", Role.values());
        return "saveUser";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("user", userService.findById(id));
        return "saveUser";
    }

    @RequestMapping(value = {"register"}, method = RequestMethod.POST)
    public String register(Model model, User user) {
        userService.userRegistration(user);
        return "/login";
    }

    @RequestMapping(value = {"saveUser"}, method = RequestMethod.POST)
    public String save(Model model, User user){
        userService.userRegistration(user);
        return viewUsers(model);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String deleteById(Model model, Long id){
        if (userService.count() > 1L) userService.deleteById(id);
        return viewUsers(model);
    }

}
