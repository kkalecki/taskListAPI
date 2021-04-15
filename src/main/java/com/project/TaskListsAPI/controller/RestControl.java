package com.project.TaskListsAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

    @GetMapping("/")
    public String welcomeEveryone()
    {
        return "<h1>Welcome Everyone</h1>";
    }
    @GetMapping("/user")
    public String welcomeUser()
    {
        return "<h1>Welcome Everyone Logged in</h1>";
    }
    @GetMapping("/admin")
    public String welcomeAdmin()
    {
        return "<h1>Welcome Admin!</h1>";
    }


}
