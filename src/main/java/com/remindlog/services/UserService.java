package com.remindlog.services;

import com.remindlog.models.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
//    Optional<User> findAUserById(Long id);
    User findAUserByEmail(String email);
    void deleteAUser(User user);
    void saveAUser(User user);
    User findAUserByUsername(String username);
    void editUser(User userFromFrontend, User theUser);
//    void editPassword(User UserFromFrontend, User user);
}
