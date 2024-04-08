package com.graduo.demo.jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Obtiene el token de autenticación de la solicitud entrante
        final String token = getTokenFromRequest(request);
        // Verifica si el token es nulo
        if(token==null){
            // Si el token es nulo, permite que la solicitud continúe su procesamiento
        // y la pasa al siguiente filtro en la cadena de filtros
            filterChain.doFilter(request, response);
        }
        // Si el token no es nulo, la solicitud se procesará de todos modos.
        // Nota: En este punto, es posible que desee realizar alguna acción
        // adicional relacionada con la presencia de un token de autenticación,
        // como la validación del token o la autenticación del usuario.
        // Por el momento, esta lógica está ausente en el filtro.

        // Se pasa la solicitud al siguiente filtro en la cadena de filtros,
        // ya que no se ha tomado ninguna acción específica en este filtro.
        filterChain.doFilter(request, response);
    }
    // Método para extraer el token de autenticación de la solicitud
    private String getTokenFromRequest(HttpServletRequest request) {
        // Obtiene el valor de la cabecera de autorización de la solicitud
       final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        // Verifica si la cabecera de autorización no está vacía y comienza con el prefijo "Bearer "
       if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
        // Si se cumple la condición, devuelve el token de autenticación
        // después de eliminar el prefijo "Bearer "
        return authHeader.substring(7);
       }
       // Si no se cumple la condición anterior, devuelve null
       return null;
    }

    
    
}
