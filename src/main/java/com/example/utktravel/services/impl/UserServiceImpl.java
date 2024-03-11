package com.example.utktravel.services.impl;

import com.example.utktravel.entities.User;
import com.example.utktravel.repositories.UserRepository;
import com.example.utktravel.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public String activateUser(String token) {
        User user = userRepository.findByActivationToken(token);
        if (user != null) {
            user.setEnabled(true);
            userRepository.save(user);
            return "User verified successfully";
        } else {
            return "Invalid token";
        }
    }
}
