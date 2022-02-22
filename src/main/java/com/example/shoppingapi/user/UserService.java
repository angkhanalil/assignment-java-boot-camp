package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> ShowUserData(@NotNull RequestSignIn signin) {
        String email = signin.getEmail();
        User result = userRepository.findByEmail(email);
        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK) ;
        }
        throw new UserNotFoundException(email.toString());

    }

    public String ShowData(Integer id) {
        Optional<User> result = userRepository.findByUserId(id);
        if (result.isPresent()) {
            return "Hello " + result.get().getFullName();
        }
        throw new UserNotFoundException(id.toString());

    }

}
