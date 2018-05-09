package com.remindlog.services;

import com.remindlog.models.Reminder;
import com.remindlog.models.User;
import com.remindlog.repositories.ReminderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService {

    private ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public Reminder findAReminderByNameAndUser(String name, User user) {
        return reminderRepository.findByNameAndUser(name, user);
    }

    @Override
    public void saveAReminder(Reminder reminder) {
        reminderRepository.save(reminder);
    }
}
