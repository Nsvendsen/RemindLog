package com.remindlog.repositories;

import com.remindlog.models.Reminder;
import com.remindlog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    Reminder findByNameAndUser(String name, User user);
}
