package com.catarsi.Rifugio_Animali.config;

import com.catarsi.Rifugio_Animali.business.model.User;
import com.catarsi.Rifugio_Animali.business.repos.RifugioRepoUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private RifugioRepoUtente utenteRepository;

    // UserDetailsService per caricare utente da DB
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            System.out.println("Login tentativo con: " + username);
            User user = utenteRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con email: " + username));
            System.out.println("Utente trovato: " + user.getEmail());
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())  // password già hashata nel DB
                    .roles(user.getRuolo())       // es. "ADMIN" o "USER"
                    .build();
        };
    }

    // Password encoder BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configurazione sicurezza HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**", "/signin", "/animali/**", "/adozioni/**", "/donazioni/**", "/image/**").permitAll()
                        .requestMatchers("/backoffice/adozioni/add").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/gest", "/backoffice/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(customSuccessHandler())
                        .permitAll()
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

    // Redirect in base al ruolo dopo login
    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return (request, response, authentication) -> {
            boolean isAdmin = authentication.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));
            if (isAdmin) {
                response.sendRedirect("/gest");
            } else {
                response.sendRedirect("/");
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        var authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authBuilder.userDetailsService(username -> {
            System.out.println("Tentativo di login con email: " + username);

            return utenteRepository.findByEmail(username)
                    .map(utente -> {
                        System.out.println("Trovato utente: " + utente.getEmail() + " con ruolo: " + utente.getRuolo());
                        return org.springframework.security.core.userdetails.User.builder()
                                .username(utente.getEmail())
                                .password(utente.getPassword())
                                .roles(utente.getRuolo()) // "ADMIN" o "USER", senza "ROLE_"
                                .build();
                    })
                    .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato: " + username));
        }).passwordEncoder(passwordEncoder());

        return authBuilder.build();
    }


    // OMAR
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .csrf(csrf -> csrf.disable()) // ❗Disabilita CSRF per consentire PUT, POST, DELETE
    //         .authorizeHttpRequests(auth -> auth
    //             .anyRequest().permitAll() // ❗Permette tutte le richieste senza autenticazione
    //         );
    //     return http.build();
    // }
}



