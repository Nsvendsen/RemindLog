package com.remindlog.repositories;

import com.remindlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    User findById(Long aLong);
    User findByEmail(String email);
    User findByUsername(String username);
}
