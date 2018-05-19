package com.remindlog.services;

import com.remindlog.models.Reminder;
import com.remindlog.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ReminderTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUserTest(){
        //Init User object and set values
        User user = new User();
        user.setUsername("test123");
        user.setPassword("hej");
        user.setEmail("test@123.dk");
        user.setPhoneNumber(11111111);

        //Insert User in database
        userService.createUser(user);

        //Init Reminder object and set values
        Reminder reminder = new Reminder();
        reminder.setName("reminder");
        reminder.setDescription("reminder test");
        reminder.setDate("15-09-2018");
        reminder.setTime("15:00");

        //Add Reminder to User object and save to database
        User userFromDatabase = userService.findAUserByUsername(user.getUsername());
        userFromDatabase.addReminder(reminder);
        userService.saveAUser(userFromDatabase);

        //Find Reminder in database
        Reminder testReminder = user.getReminders().get(0);

        //Test the Reminder
        assertNotNull(testReminder); //slet?
        assertEquals("reminder", testReminder.getName());
        assertEquals("reminder test", testReminder.getDescription());
        assertEquals("15-09-2018", testReminder.getDate());
        assertEquals("15:00", testReminder.getTime());

        //Delete user from database, should delete reminder due to cascade
        userService.deleteAUser(user);
    }
}
