package com.upc.proyecto1.channel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class GlobalCorsConfig {

  @Bean
  public CorsWebFilter corsWebFilter() {
    CorsConfiguration config = new CorsConfiguration();

    // Lista de orígenes permitidos
    config.setAllowedOrigins(Arrays.asList(
        "http://localhost:4200",
        "https://cognitivetechsolution.com"
    ));

    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    config.setAllowedHeaders(Arrays.asList("*"));
    config.setAllowCredentials(true); // si necesitas cookies/autenticación

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config); // aplica a todos los endpoints

    return new CorsWebFilter(source);
  }
}
