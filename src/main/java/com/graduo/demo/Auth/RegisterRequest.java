package com.graduo.demo.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Estas clases están utilizando anotaciones de Lombok 
// (@Data, @Builder, @AllArgsConstructor, @NoArgsConstructor) 
// para generar automáticamente métodos como getters, setters, constructores 
// y otros métodos útiles. Aquí tienes una explicación de cada línea en ambas clases:

// @Data: Esta anotación de Lombok genera automáticamente los métodos toString, 
// equals, hashCode, getter y setter para todos los campos de la clase.

// @Builder: Esta anotación de Lombok genera un constructor de tipo "builder",
//  que permite construir instancias de la clase de manera más legible y concisa.

// @AllArgsConstructor: Esta anotación de Lombok
//  genera un constructor que acepta argumentos para todos los campos de la clase.

// @NoArgsConstructor: Esta anotación de Lombok genera un constructor sin argumentos.

@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor

public class RegisterRequest {
    String username;
    String password;
    String fisrtname;
    String lastname;
    String country;
}
