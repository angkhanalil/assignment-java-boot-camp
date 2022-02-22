package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean //จำลอง bean = จำลอง userrepository
    private UserRepository userRepository;

    @Test
    @DisplayName("Sign In with E-mail")
    void signIn() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");

        RequestSignIn requestSignIn = new RequestSignIn();
        requestSignIn.setEmail("angkhana");

        when(userRepository.findByEmail("angkhana")).thenReturn(user);

        //Act
        User result = testRestTemplate.postForObject("/SingIn", requestSignIn, User.class);
        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("success case search by userid")
    void findUserData() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");
        when(userRepository.findByUserId(1)).thenReturn(Optional.of(user));
        //Act
        String result = testRestTemplate.getForObject("/user/1", String.class);

        //Assert
        assertEquals("Hello nanniiz", result);
    }

    @Test
    @DisplayName("error case search by userid")
    void caseerr_fullname() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");
        when(userRepository.findByUserId(1)).thenReturn(Optional.of(user));
        //Act
        String result = testRestTemplate.getForObject("/user/2", String.class);

        //Assert
        assertEquals("User not found", result);
    }

}