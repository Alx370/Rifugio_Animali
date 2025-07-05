package com.catarsi.Rifugio_Animali.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //noinspection removal
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/home", "/css/", "/js/", "/images/").permitAll()
                        .requestMatchers("/signin", "/animali", "/animali/", "/image/**").permitAll()
                        .anyRequest().authenticated() //quando la richiesta matcha /, /home permetti all'utente di navigare, le altre richieste autenticamele
                )
                .formLogin(form -> form
                        .loginPage("/login").defaultSuccessUrl("/", true).permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );

        return http.build();
    }

    // OMAR---------------
// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     http
//         .csrf(csrf -> csrf.disable()) // ❗Disabilita CSRF per consentire PUT, POST, DELETE
//         .authorizeHttpRequests(auth -> auth
//             .anyRequest().permitAll() // ❗Permette tutte le richieste senza autenticazione
//         );
//     return http.build();
// }

//------------------

    // @Bean
    // public UserDetailsService userDetailsService(){
    //     UserDetails user=User.withDefaultPasswordEncoder()
    //                         .username("user")
    //                         .password("password")
    //                         .roles("USER")
    //                         .build();
    //     return new InMemoryUserDetailsManager(user);

    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}


