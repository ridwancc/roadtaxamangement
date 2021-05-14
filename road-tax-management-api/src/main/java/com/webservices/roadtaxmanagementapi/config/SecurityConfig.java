package com.webservices.roadtaxmanagementapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    String jwkSetUri = "http://localhost:8180/auth/realms/RoadTaxManagementService/protocol/openid-connect/certs";

    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRealmRoleConverter());
        return jwtConverter;
    }

    private static final String[] AUTH_WHITELIST = {
        // -- Swagger UI v2
        "/v2/api-docs",
        "/swagger-resources",
        "/swagger-resources/**",
        "/configuration/ui",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**",
        // -- Swagger UI v3 (OpenAPI)
        "/v3/api-docs/**",
        "/swagger-ui/**",
        // -- Keycloak
        "/auth/*"
    };

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()

            // No authentication for swagger-ui
            .antMatchers(AUTH_WHITELIST).permitAll()

            // User endpoints
            .antMatchers(HttpMethod.GET, "/roadtax/*").hasRole("app-user")
            .antMatchers(HttpMethod.GET, "/payments").hasRole("app-user")

            // Admin only endpoints
            .antMatchers(HttpMethod.GET, "/**").hasRole("app-admin")
            .antMatchers(HttpMethod.POST, "/**").hasRole("app-admin")
            .antMatchers(HttpMethod.PUT, "/**").hasRole("app-admin")
            .antMatchers(HttpMethod.PATCH, "/**").hasRole("app-admin")
            .antMatchers(HttpMethod.DELETE, "/**").hasRole("app-admin")

            .anyRequest().authenticated().and().oauth2ResourceServer().jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()));
    }

    
}
