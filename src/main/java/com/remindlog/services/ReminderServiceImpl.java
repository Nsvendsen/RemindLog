package com.remindlog.services;

import com.remindlog.models.Reminder;
import com.remindlog.models.ReminderPost;
import com.remindlog.models.ShareGroup;
import com.remindlog.models.User;
import com.remindlog.repositories.ReminderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReminderServiceImpl implements ReminderService {

    private ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

//    @Override
//    public Reminder findAReminderByNameAndUser(String name, User user) {
//        return reminderRepository.findByNameAndUser(name, user);
//    }


    @Override
    public Reminder findAReminderById(Long id) {
//        return reminderRepository.findById(id);
        return reminderRepository.getOne(id);
    }

    //Used to update Reminder
    @Override
    public void editReminder(Reminder reminder) {
        Reminder reminderToUpdate = reminderRepository.getOne(reminder.getId());
        reminderToUpdate.setName(reminder.getName());
        reminderToUpdate.setDescription(reminder.getDescription());
        reminderToUpdate.setDate(reminder.getDate());
        reminderToUpdate.setTime(reminder.getTime());
        reminderRepository.save(reminderToUpdate);
    }

//    @Override
//    public void deleteReminder(Reminder reminder) { //Is it relevant to delete the Reminder from the user side aswell?
//        reminderRepository.delete(reminder);
//    }

    @Override
    public void deleteReminderById(Long id) {
        reminderRepository.deleteById(id);
    }

    @Override
    public Reminder convertReminder(ReminderPost reminderPost, ShareGroup shareGroup) {
        //bad code practice
        Reminder reminder = new Reminder();
        reminder.setName(reminderPost.getName());
        reminder.setDescription(reminderPost.getDescription());
        if (reminderPost.getDate() != null)
            reminder.setDate(reminderPost.getDate());
        if (reminderPost.getTime() != null)
            reminder.setTime(reminderPost.getTime());
        if (shareGroup.getId() != null)
            reminder.setShareGroup(shareGroup);

        return reminder;
    }
}
