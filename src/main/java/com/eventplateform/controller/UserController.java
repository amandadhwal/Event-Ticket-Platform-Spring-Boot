package com.eventplateform.controller;

import com.eventplateform.dto.LoginRequest;
import com.eventplateform.entity.User;
import com.eventplateform.security.JwtUtil;
import com.eventplateform.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    //register user
    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return userService.register(user);
    }

    //get user by email
    @GetMapping
    public User getUser(@RequestParam String email)
    {
        return userService.getByEmail(email);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req) {

        User user = userService.getByEmail(req.getEmail());

        if (!user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return JwtUtil.generateToken(user.getEmail());
    }


}
