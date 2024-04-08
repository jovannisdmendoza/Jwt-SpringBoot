package com.graduo.demo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterchain(HttpSecurity http) throws Exception  {

        return http.
        // Deshabilita la protección CSRF
        csrf(csrf-> 
        csrf.disable()).

        // Configura las reglas de autorización para las solicitudes HTTP.
        authorizeHttpRequests(authRequest -> 
        // Permite acceso sin autenticación a las URLs que coinciden con "/auth/**".
        // Estas URLs podrían utilizarse, por ejemplo, para el proceso de inicio de sesión.
        authRequest
        .requestMatchers("/auth/**").permitAll()
         // Requiere autenticación para cualquier otra URL que no coincida
                // con el patrón "/auth/**". Esto significa que el usuario debe iniciar sesión
                // para acceder a cualquier otra parte del sitio.
        .anyRequest().authenticated() 
        )
        // Configura la autenticación mediante formulario.
        // Esto significa que se utilizará un formulario de inicio de sesión estándar
        // para que los usuarios ingresen sus credenciales.
        .formLogin(withDefaults()).build();
    }
    
}
