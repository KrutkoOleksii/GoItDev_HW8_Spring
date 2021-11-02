//package ua.goit.hw8Spring.configuration;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("javainuse")
//                .password("javainuse")
//                .roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .anyRequest()
//                .hasRole("USER")
//                    .and()
//                .formLogin()
//                .loginPage("/login.jsp")
////                .failureUrl("/login.jsp?error=1")
////                .loginProcessingUrl("/login")
//                .permitAll()
//                    .and()
//                .logout()
////                .logoutSuccessUrl("/index.jsp")
//                .permitAll();
//    }
//}