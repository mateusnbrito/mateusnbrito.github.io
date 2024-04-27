package com.fareieumesmo.site.security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Value("${jwt.public.key}")
  private RSAPublicKey key;
  @Value("${jwt.private.key}")
  private RSAPrivateKey priv;

  @Bean
  public AuthenticationManager authManager(UserDetailsService detailsService) {
    DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();

    daoProvider.setUserDetailsService(detailsService);
    daoProvider.setPasswordEncoder(passwordEncoder());

    return new ProviderManager(daoProvider);
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .cors(cors -> {
          cors.configurationSource(request -> {
            var corsConf = new CorsConfiguration();

            corsConf
                .setAllowedOrigins(List.of("http://localhost:2412"));
            corsConf.setAllowedMethods(
                List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT", "PATCH"));
            corsConf.setAllowedHeaders(List.of("*"));

            return corsConf;
          });
        })
        .authorizeHttpRequests(
            auth -> {
              auth.requestMatchers("/auth/**", "/autenticacao/**", "/index.html").permitAll();
              auth.anyRequest().authenticated();
            })
        .formLogin(formLogin -> {
          formLogin.loginPage("/autenticacao/login.html");
        })
        .logout(logout -> {
          logout.logoutUrl("/autenticacao/logout.html");
          logout.logoutSuccessUrl("/");
          logout.clearAuthentication(true);
          logout.invalidateHttpSession(true);
          logout.deleteCookies("JSESSIONID");
        })
        .oauth2ResourceServer(
            conf -> conf.jwt(
                jwt -> jwt.decoder(jwtDecoder())));
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder.withPublicKey(this.key).build();
  }

  @Bean
  JwtEncoder jwtEncoder() {
    JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
    JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));

    return new NimbusJwtEncoder(jwks);
  }
}
