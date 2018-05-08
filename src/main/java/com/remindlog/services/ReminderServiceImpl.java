package com.remindlog.services;

import com.remindlog.repositories.ReminderRepository;

public class ReminderServiceImpl implements ReminderService {

    private ReminderRepository reminderRepository;

    public ReminderServiceImpl(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }
}
