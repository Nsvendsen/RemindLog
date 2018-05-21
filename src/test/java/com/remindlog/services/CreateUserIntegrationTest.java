package com.remindlog.services;

import com.remindlog.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CreateUserIntegrationTest {

//    @Autowired
//    private UserService userService;
//
//    //Integration Test
//    @Test
//    public void createUserTestHappyPath(){
//        //Init User object and set values
//        User user = new User();
//        user.setUsername("test123");
//        user.setPassword("hej"); //Test password??
//        user.setEmail("test@123.dk");
////        user.setPhoneNumber(11111111);
//
//        //Insert user in database
//        User testUser = userService.createUser(user);
//
//        //Test the user
//        assertNotNull(testUser);
//        assertNotNull(testUser.getId());
//        assertEquals("test123", testUser.getUsername());
////        assertEquals(new BCryptPasswordEncoder().encode(user.getPassword()), testUser.getPassword());
//        assertEquals("test@123.dk", testUser.getEmail());
////        assertEquals(11111111, testUser.getPhoneNumber());
//        assertTrue(testUser.isEnabled());
//        assertEquals("USER", testUser.getRole());
//
//        //Delete user from database
//        userService.deleteAUser(user);
//    }

//    @Test
//    public void deleteAUserTest(){
//        userService.deleteAUser(user);
//    }

//    @Test
//    public void databaseEncryptionTest(){
//
//    }
}
