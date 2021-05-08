package com.project.TaskListsAPI.service;


import com.project.TaskListsAPI.common.Hasher;
import com.project.TaskListsAPI.configuration.Properties;
import com.project.TaskListsAPI.controller.model.Token;
import com.project.TaskListsAPI.controller.model.UserRequestLogin;
import com.project.TaskListsAPI.repository.UserRepository;
import com.project.TaskListsAPI.repository.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenUserService {

    private final UserRepository userRepository;
    private final Properties properties;


    public void save(User user)
    {
        String password = user.getPassword();
        String hashedPassword = Hasher.hash(password);
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public Token login(User loggedUser)
    {

        User user = userRepository.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new EntityNotFoundException("Nie ma"));
        String password = Hasher.hash(loggedUser.getPassword());

        if(password.equals(user.getPassword()))
        {

            String token = Jwts.builder().claim("role", user.getRole())
                    .setSubject(user.getUsername())
                    .signWith(SignatureAlgorithm.HS256, properties.getConfig("secret")).compact();

            return new Token(token);
        }
        else
        {
            throw new RuntimeException("Password doesnt match");
        }

    }
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("nie ma takiego usera"));
    }

}
