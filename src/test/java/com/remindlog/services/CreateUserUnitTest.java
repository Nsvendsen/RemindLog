package com.remindlog.services;

import com.remindlog.models.User;
import com.remindlog.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CreateUserUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    //Unit Test
    @Test
    public void createUserTestHappyPath(){
        //Init User object and set values
        User user = new User();
        user.setUsername("test123");
//        user.setPassword("hej"); //Test password??
        user.setEmail("test@123.dk");
//        user.setPhoneNumber(11111111);

        when(userRepository.save(any(User.class))).thenReturn(user); //userRepository.save() eller userServiceImpl.createNewUser()

        //Create User
//        User testUser = userServiceImpl.createUser(null);
        //TEST
        User testUser = userRepository.save(user); //pass user instead of null?

        //Verify
        assertEquals("test123", testUser.getUsername());
//        assertEquals(new BCryptPasswordEncoder().encode(user.getPassword()), testUser.getPassword());
        assertEquals("test@123.dk", testUser.getEmail());
//        assertEquals(11111111, testUser.getPhoneNumber());

//        assertTrue(testUser.isEnabled());
//        assertEquals("USER", testUser.getRole());
    }
}
