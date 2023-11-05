package com.auth.authentication.Security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.userdetails.*;
import com.auth.authentication.Security.SecurityServices.CoustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth.authentication.Jwt.*;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    JwtFilter jwtFilter;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new CoustomUserDetailsService();
    }
    // "/teachers/**",
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http.csrf().disable()
        .authorizeHttpRequests()
        .requestMatchers("/dashboard","/signup","/signin","/auth","/revecampus/student/**",
        "/authenticate","/category/addcategory","/category/getcategories",
        "/quize/**","/question/**","/admindetails/**"
        ,"/user/quizes/**","/student/**","/revecampus/student/profile/**",
        "/user/email/**","/admin/**"
        )
        .permitAll()
        .and()
        .authorizeHttpRequests()
        .anyRequest()
        .authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService());
        dao.setPasswordEncoder(passwordEncoder());
        return dao;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
        return configuration.getAuthenticationManager();
    }
}
