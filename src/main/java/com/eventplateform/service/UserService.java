package com.eventplateform.service;

import com.eventplateform.entity.User;
import com.eventplateform.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    //Register user
    public User register(User user)
    {
        if(userRepository.existsByEmail(user.getEmail()))
        {
            throw new RuntimeException("email already registerd");
        }
        return userRepository.save(user);
    }

    //find user by email(used in login)
    public User getByEmail(String email)
    {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found"));
    }
}
