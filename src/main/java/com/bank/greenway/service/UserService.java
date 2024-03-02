package com.bank.greenway.service;

import com.bank.greenway.entity.User;
import com.bank.greenway.entity.Role;
import com.bank.greenway.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public boolean createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) return false;
        user.setActive(true);
        user.getRoles().add(Role.USER);
        return true;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
