// package com.code.borrow.configuration;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .authorizeRequests()
//                 .antMatchers("/library/**").hasRole("LIBRARY_USER") // Secure all URLs under /library
//                 .anyRequest().authenticated() // Any other URL requires authentication
//                 .and()
//             .formLogin()
//                 .loginPage("/librarylogin") // Custom login page URL
//                 .permitAll() // Allow access to the login page
//                 .and()
//             .logout()
//                 .logoutSuccessUrl("/login") // URL to redirect after logout
//                 .permitAll(); // Allow access to the logout URL
//     }

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth
//             .inMemoryAuthentication()
//                 .withUser("username").password("{noop}password").roles("LIBRARY_USER"); // Example user with role
//     }
// }

