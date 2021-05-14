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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TokenUserService {

    private final UserRepository userRepository;
    private final Properties properties;


    public boolean save(User user) {

        String username = user.getUsername();
        Optional<User> checkIfUserExists = userRepository.findByUsername(username);
        if(checkIfUserExists.isEmpty())
        {
            String password = user.getPassword();
            String hashedPassword = Hasher.hash(password);
            user.setPassword(hashedPassword);

            userRepository.save(user);
            return true;
        }
        else
        {
            return false;
        }



    }

    public Token login(User loggedUser) {

        Optional<User> user = userRepository.findByUsername(loggedUser.getUsername());
        if(user.isEmpty())
        {
            return new Token("",false,false);
        }
        else {

            String password = Hasher.hash(loggedUser.getPassword());

            if (password.equals(user.get().getPassword())) {

                String token = Jwts.builder().claim("role", user.get().getRole())
                        .setSubject(user.get().getUsername())
                        .signWith(SignatureAlgorithm.HS256, properties.getConfig("secret")).compact();

                if(user.get().getRole().equals("PARENT"))
                {
                    return new Token(token,true,true);
                }
                else
                {
                    return new Token(token,true,false);
                }


            } else {
                return new Token("",false,false);
            }
        }

    }

    public User findByUsername(String username) {

        return userRepository.findByUsername(username).orElse(new User());
    }

    public List<String> findChildrenNames(String username) {
        User user = findByUsername(username);
        return user.getChildren().stream().map(User::getUsername).collect(Collectors.toList());

    }

}
