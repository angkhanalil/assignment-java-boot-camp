package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void showUserData() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");

        RequestSignIn requestSignIn =  new RequestSignIn();
        requestSignIn.setEmail("angkhana");

        when(userRepository.findByEmail("angkhana")).thenReturn(user);
        //Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        ResponseEntity<User> result = userService.ShowUserData(requestSignIn);
        //Assert
        assertEquals(new ResponseEntity<>(user, HttpStatus.OK),result );
    }

    @Test
    @DisplayName("success find by userid ")
    void showData() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");

        when(userRepository.findByUserId(1)).thenReturn(Optional.of(user));
        //Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        String result = userService.ShowData(1);
        //Assert
        assertEquals("Hello nanniiz",result );

    }

    @Test
    void err_case() {
        //Arrange
//        User user = new User();
//        user.setUserId(1);
//        user.setFullName("nanniiz");
//        user.setEmail("angkhana");
//        when(userRepository.findByUserId(5)).thenReturn(Optional.of(user));
//        //Act
//        UserService userService = new UserService();
//        userService.setUserRepository(userRepository);
//        String result = userService.ShowData(5);
//        //Assert
//        assertEquals("User not found", result);

    }


}