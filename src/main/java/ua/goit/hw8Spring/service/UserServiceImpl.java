package ua.goit.hw8Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.hw8Spring.model.Role;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;

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

}
