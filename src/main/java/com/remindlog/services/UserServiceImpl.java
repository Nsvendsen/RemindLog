package com.remindlog.services;

import com.remindlog.models.User;
import com.remindlog.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole("USER");
        userRepository.save(user);
    }

    @Override
    public User findAUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteAUser(User user) {
        userRepository.delete(user);
    }
}