package fr.mallyance.crm.exposition.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour simplifier les tests
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Configurer CORS
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/api/**").permitAll()
                        //.requestMatchers("/v3/api-docs/**").permitAll()// Autoriser l'accès à la doc de swagger
                        //.requestMatchers("/swagger-ui/**").permitAll() // Autoriser l'accès au swagger
                        .requestMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs/**", "/actuator/prometheus").permitAll()
                        .anyRequest().authenticated() // Protéger les autres requêtes
                );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(false); // Désactiver les credentials

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

