package ua.goit.hw8Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements BaseService<User,Long>{

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    public void userRegistration(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String name){
        return  userRepository.findByEmail(name).orElse(null);
    }

    public User findById(Long id){
        return  userRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        if (userRepository.count()>1L) userRepository.deleteById(id);
    }

    public Long count(){
        return userRepository.count();
    }
}
