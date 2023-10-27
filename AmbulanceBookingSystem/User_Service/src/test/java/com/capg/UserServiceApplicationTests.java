package com.capg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.controller.UserController;
import com.capg.entity.User;
import com.capg.exception.IdNotFoundException;
import com.capg.repository.UserRepository;
import com.capg.service.UserService;

@SpringBootTest

class UserServiceApplicationTests {

    @Autowired

    UserService userService;

    @Autowired

    private UserController userController;

    @MockBean

    private UserRepository userRepository;

    private User user1;

    private User user2;

    @BeforeEach

    public void userServiceTestSetup() {

        user1 = new User("1234", "Kshitiz", "8989898989", "kshitiz@gmail.com", "Indore", "Password@123");

        user2 = new User("1235", "Vipin", "8989898989", "vipin@gmail.com", "Indore", "Password@123");

    }

    @Test

    public void createUserTest() {

        Mockito.when(userRepository.save(user1)).thenReturn(user1);

        assertThat(userService.createUser(user1)).isEqualTo(user1);

    }

    @Test

    public void updateUserTest() {

        Mockito.when(userRepository.save(user1)).thenReturn(user1);

        Mockito.when(userRepository.findById("1234")).thenReturn(Optional.of(user1));

        //User result = userService.updateUser("1234", "Kshitiz", "8989898989");

//      assertEquals("Kshitiz", result.getUserName());
//
//      assertEquals("8989898989", result.getUserContactNumber());

    }

@Test

public void testDeleteUser_ValidId() {

// Arrange

when(userRepository.findById("1234")).thenReturn(Optional.of(user1));

doNothing().when(userRepository).delete(user1);

 

try {

userController.deleteUser("1234");

} catch (IdNotFoundException e) {

fail("Unexpected exception: " + e.getMessage());

}

 

// Verify that the repository methods were called

verify(userRepository, times(1)).findById("1234");

verify(userRepository, times(1)).delete(user1);

}

@Test

public void testDeleteUser_InvalidId() {

// Arrange

when(userRepository.findById("invalid_id")).thenReturn(Optional.empty());

 

try {

userController.deleteUser("invalid_id");

fail("Expected IdNotFoundException, but no exception was thrown");

} catch (IdNotFoundException e) {

// Assert the exception message

assertEquals("Not Found user", e.getMessage());

}

 

// Verify that the repository method was called

verify(userRepository, times(1)).findById("invalid_id");

verifyNoMoreInteractions(userRepository);

}

    @Test

    public void getUserByIdTest() {

        Mockito.when(userRepository.findById("1234")).thenReturn(Optional.of(user1));

        assertThat(userService.getUserById("1234")).isEqualTo(Optional.of(user1));

    }

    @Test

    public void getUserByEmailIdTest() {

        Mockito.when(userRepository.getUserByUserEmailId("kshitiz@gmail.com")).thenReturn(Optional.of(user1));

        assertThat(userService.getUserByEmailId("kshitiz@gmail.com")).isEqualTo(Optional.of(user1));

    }

    @Test

    public void viewAllUserTest() {

        List<User> users = new ArrayList<>();

        users.add(user1);

        users.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        assertThat(userService.viewAllUser()).isEqualTo(users);

    }

}