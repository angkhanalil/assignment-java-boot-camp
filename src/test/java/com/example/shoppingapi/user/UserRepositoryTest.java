package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserId_With_success() {
        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");
        //Act
        Optional<User> result = userRepository.findByUserId(1);
        //Assert
        assertTrue(result.isPresent());

    }



    @Test
    void findByEmail_With_success() {

        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");
        //Act
        User result = userRepository.findByEmail("angkhana");
        //Assert
        assertNotNull(result);
    }

    @Test
    void findByEmail_Faile() {

        User user = new User();
        user.setUserId(1);
        user.setFullName("nanniiz");
        user.setEmail("angkhana");
        //Act
        User result = userRepository.findByEmail("angkh");
        //Assert
        assertNull(result);
    }
}