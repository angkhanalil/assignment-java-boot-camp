package com.example.shoppingapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public  String sayhi(@PathVariable Integer id){
        return userService.ShowData(id);
    }

    @GetMapping("/userfullname/{fullname}")
    public  String userfullname(@PathVariable String fullname){
        return userService.UserFullname(fullname);
    }
}
