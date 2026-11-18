/* package pricing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilitar CSRF para permitir peticiones POST, PUT y DELETE desde archivos .http
            .csrf(csrf -> csrf.disable())
            // 2. Exigir autenticación en todas las rutas
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            // 3. Habilitar autenticación básica (usuario y contraseña en cabecera HTTP)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
} */



//Authorization: Basic user 68f5fad7-2815-4863-94ed-00e7bfb7dd4b