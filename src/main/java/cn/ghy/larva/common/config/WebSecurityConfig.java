package cn.ghy.larva.common.config;

import cn.ghy.larva.common.security.JwtAuthenticationFilter;
import cn.ghy.larva.common.security.service.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Ziyang
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

  @Autowired
  CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
    return new JwtAuthenticationFilter();
  }

  @Bean
  public WebSecurityCustomizer webSecurityCustomizer() {
    return web -> web.ignoring()
            .requestMatchers("/swagger-resources/**", "/swagger-ui.html", "/configuration/**", "/webjars/**", "/public");
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService)
          throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(customUserDetailsServiceImpl)
            .passwordEncoder(bCryptPasswordEncoder)
            .and()
            .build();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable().build();
  }
}