package com.remindlog.services;

import com.remindlog.models.Reminder;
import com.remindlog.models.User;

public interface ReminderService {
    Reminder findAReminderByNameAndUser(String name, User user);
    void saveAReminder(Reminder reminder);
}
