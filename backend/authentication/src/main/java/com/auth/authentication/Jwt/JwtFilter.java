package com.auth.authentication.Jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.filter.*;

import com.auth.authentication.Security.SecurityServices.*;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    CoustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // get auth header
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer")) {
            token = authHeader.substring(7);
            try {
                username = this.jwtUtil.extractUsername(token);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // main security code
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // validate the token
                if (jwtUtil.validateToken(token, userDetails)) {
                    System.out.println("-------------- usr is validated");
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,null,userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } else {
                System.out.println("token is not validated");
            }

        }
        

        filterChain.doFilter(request, response);
    }

}
