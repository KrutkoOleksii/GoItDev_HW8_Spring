package ua.goit.hw8Spring.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
//@RestController
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserRepository userRepository;

    @RequestMapping(value = {"users"}, method = RequestMethod.GET)
    public String findAll(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users",userList);
        return "users";
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
