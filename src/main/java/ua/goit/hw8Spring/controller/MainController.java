package ua.goit.hw8Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    //@GetMapping("/login")
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (Objects.nonNull(error)) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (Objects.nonNull(logout)) {
            model.addAttribute("message", "You have been logged out successfully");
        }
        return "login";
    }
}
