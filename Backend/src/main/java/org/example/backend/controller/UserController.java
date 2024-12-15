package org.example.backend.controller;

import org.example.backend.domain.Scene;
import org.example.backend.domain.User;
import org.example.backend.dto.*;
import org.example.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private SceneService sceneService;
    private ClassService classService;
    private ChatService chatService;
    private ChatCommentService chatCommentService;


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

    @Autowired
    public void setChatService(ChatService chatService) {
        this.chatService = chatService;
    }

    @Autowired
    public void setChatCommentService(ChatCommentService chatCommentService) {
        this.chatCommentService = chatCommentService;
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

    @PostMapping("/usersChats")
    public List<ChatDto> getUsersChats(@RequestBody UserDto userDto) {
        return chatService.getUsersChats(userDto);
    }

    @PostMapping("/usersChatComments/{chatId}")
    public List<ChatCommentDto> getUsersChatComments(@PathVariable Integer chatId) {
        return chatCommentService.getUsersChatComments(chatId);
    }



}
