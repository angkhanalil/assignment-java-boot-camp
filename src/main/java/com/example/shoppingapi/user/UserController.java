package com.example.shoppingapi.user;

import com.example.shoppingapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/SignIn")
    public ResponseEntity<User> SignIn(@RequestBody RequestSignIn email) {
        // Sing in with email
        return userService.ShowUserData(email);
    }

    @GetMapping("/user/{id}")
    public String findUserData(@PathVariable Integer id) {
        return userService.ShowData(id);
    }

//    @GetMapping("/user/{id}/cart")

//    @GetMapping("/user/{id}/order")

//    @GetMapping("/user/{id}/order/{orderid}")

}
