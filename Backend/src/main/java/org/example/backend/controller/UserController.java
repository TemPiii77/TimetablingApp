package org.example.backend.controller;

import org.example.backend.domain.User;
import org.example.backend.dto.UserDto;
import org.example.backend.service.JWTService;
import org.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/register")
//    public User register(@RequestBody User user) {
//        return userService.register(user);
//    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {

        return userService.verify(userDto);
    }

    @PostMapping("/userInformation")
    public UserDto getUser(@RequestBody String token) {
        return userService.getName(token);
    }


}