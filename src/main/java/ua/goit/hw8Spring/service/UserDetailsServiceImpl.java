package ua.goit.hw8Spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElse(null);

//        Set<GrantedAuthority> roles = new HashSet();
//        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
//        UserDetails userDetails =
//                new org.springframework.security.core.userdetails.User(user.getEmail(),
//                        user.getPassword(),
//                        roles);
//        return userDetails;
        return new UserDetailsImpl(user);
    }

}