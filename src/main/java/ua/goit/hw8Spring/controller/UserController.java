package ua.goit.hw8Spring.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.Producer;
import ua.goit.hw8Spring.model.Role;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
//@RestController
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserRepository userRepository;

    @RequestMapping(value = {"users"}, method = RequestMethod.GET)
    public String viewUsers(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users",userList);
        return "users";
    }

    @RequestMapping(value = {"add"}, method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("mode",0);
        model.addAttribute("roles",Role.values());
        return "saveUser";
    }

    @RequestMapping(value = {"update"}, method = RequestMethod.GET)
    public String update(Model model, Long id){
        model.addAttribute("mode",1);
        model.addAttribute("producer", userRepository.findById(id).get());
        return "saveProducer";
    }

    @RequestMapping(value = {"saveProducer"}, method = RequestMethod.GET)
    public String save(Model model){
        User user = User.builder()
                .email(model.getAttribute("email").toString())
                .password(model.getAttribute("password").toString())
                .firstName(model.getAttribute("firstName").toString())
                .lastName(model.getAttribute("lastName").toString())
                .role(Role.valueOf(model.getAttribute("role").toString()))
                .build();
        User save = userRepository.save(user);
        return viewUsers(model);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public String delete(Model model, Long id){
        userRepository.deleteById(id);
        return viewUsers(model);
    }

//    @GetMapping(value = "all")
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @GetMapping({"/{id}","/"})
//    public Optional<User> findById(@PathVariable(required = false, name = "id") Optional<Long> id) {
//        return id.map(userRepository::findById).orElse(null);
//    }
//
//    @PutMapping("name")
//    public User changeEmail(@ApiParam(required = true) @RequestParam(name = "id") Long id, @RequestParam(name = "email") String email){
//        return userRepository.findById(id)
//                .map(user -> {user.setEmail(email);
//                    return userRepository.save(user);
//                })
//                .orElse(null);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable(name = "id") Long id) {
//        userRepository.deleteById(id);
//    }

}
