package org.example.backend.controller;

import org.example.backend.domain.Scene;
import org.example.backend.domain.User;
import org.example.backend.dto.ClassDto;
import org.example.backend.dto.ProblemDto;
import org.example.backend.dto.SceneDto;
import org.example.backend.dto.UserDto;
import org.example.backend.service.ClassService;
import org.example.backend.service.JWTService;
import org.example.backend.service.SceneService;
import org.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private SceneService sceneService;
    private ClassService classService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSceneService(SceneService sceneService) {
        this.sceneService = sceneService;
    }

    @Autowired
    public void setClassService(ClassService classService) {
        this.classService = classService;
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

    @PostMapping("/usersClasses")
    public List<ClassDto> getUsersClasses(@RequestBody UserDto userDto) {
        return classService.getUsersClasses(userDto);
    }

    @PostMapping("/usersScenes/{year}")
    public List<SceneDto> getUsersScenes(@PathVariable Integer year, @RequestBody UserDto userDto) {
        return sceneService.getUsersScenes(userDto, year);
    }



}
