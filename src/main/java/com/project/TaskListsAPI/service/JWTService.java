package com.project.TaskListsAPI.service;

import com.project.TaskListsAPI.configuration.Properties;
import com.project.TaskListsAPI.repository.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JWTService {

    private final Properties properties;

    public JWTService(Properties properties) {
        this.properties = properties;
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }


    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(properties.getConfig("secret")).parseClaimsJws(token).getBody();
    }


    public String generateToken(User user) {
        return Jwts.builder().claim("role", user.getRole())
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, properties.getConfig("secret")).compact();


    }

    public boolean validate(String token, User user) {
        return (getUsername(token).equals(user.getUsername()));
    }

}
