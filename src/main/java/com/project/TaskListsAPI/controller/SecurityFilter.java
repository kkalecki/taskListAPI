package com.project.TaskListsAPI.controller;

import com.project.TaskListsAPI.repository.UserRepository;
import com.project.TaskListsAPI.repository.entity.User;
import com.project.TaskListsAPI.service.JWTService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class SecurityFilter implements Filter {

    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final Set<String> publicEndPoints = new HashSet<>(Arrays.asList("/login","/user"));

    public SecurityFilter(JWTService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;

    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader("Authorization");


        if (publicEndPoints.contains(httpServletRequest.getServletPath()) || httpServletRequest.getMethod().equals("OPTIONS"))  {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (token == null) {
                throw new RuntimeException("wyjatek ze token==null");
            } else {
                boolean isValidated = jwtService.validate(token,
                        userRepository.findByUsername(jwtService.getUsername(token)).orElseThrow(() -> new EntityNotFoundException("Nie ma")));
                if (isValidated) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
                else
                {
                    throw new RuntimeException("wyjatek ze token==null");
                }
            }
        }
    }
    // other methods
}
