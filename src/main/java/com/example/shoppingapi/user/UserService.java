package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String ShowData(Integer id) {
        Optional<User> result = userRepository.findById(id);

        return "Hello " + result.get().getFullName();

    }

    public String UserFullname(String fullName) {
        User result = userRepository.findByFullName(fullName);

        return "Hello fullname id " + result.getFullName();

    }
}
