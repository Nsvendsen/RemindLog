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

    //Used to update Reminder
    @Override
    public void saveAReminder(Reminder reminder) {
        Reminder reminderToUpdate = reminderRepository.getOne(reminder.getId());
        reminderToUpdate.setName(reminder.getName());
        reminderToUpdate.setDescription(reminder.getDescription());
        reminderToUpdate.setDate(reminder.getDate());
        reminderToUpdate.setTime(reminder.getTime());
        reminderRepository.save(reminderToUpdate);
    }

    @Override
    public void deleteReminder(Reminder reminder) { //Is it relevant to delete the Reminder from the user side aswell?
        reminderRepository.delete(reminder);
    }
}
