package ua.goit.hw8Spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.goit.hw8Spring.model.Role;
import ua.goit.hw8Spring.model.User;
import ua.goit.hw8Spring.repository.UserRepository;
import ua.goit.hw8Spring.service.UserDetailsServiceImpl;
import ua.goit.hw8Spring.service.UserServiceImpl;

import java.util.Iterator;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//        User user = userRepository.findByEmail("a@a.ua").orElse(null);
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("Pass1")).roles(Role.USER.getRole())
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("Pass2")).roles(Role.USER.getRole())
//                .and()
//                .withUser(user.getEmail()).password(passwordEncoder().encode(user.getPassword())).roles(user.getRole().getRole())
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("PassAdmin")).roles(Role.ADMIN.getRole());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/anonymous*").anonymous()
                .anyRequest().authenticated()
                    .and()
                .formLogin()
                .loginPage("/login.jsp")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login.html?error=true")
                .permitAll()
                    .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();

    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}