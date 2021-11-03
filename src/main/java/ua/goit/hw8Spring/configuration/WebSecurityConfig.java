package ua.goit.hw8Spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    //private UserRepository userRepository;

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("Pass1")).roles(Role.USER.getRole())
                .and()
                .withUser("user2").password(passwordEncoder().encode("Pass2")).roles(Role.USER.getRole())
                .and()
                .withUser("admin").password(passwordEncoder().encode("PassAdmin")).roles(Role.ADMIN.getRole());
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
                .defaultSuccessUrl("/index.jsp", true)
                .failureUrl("/login.html?error=true")
//                .failureHandler(authenticationFailureHandler())
                .permitAll()
                    .and()
                .logout()
                .permitAll();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}