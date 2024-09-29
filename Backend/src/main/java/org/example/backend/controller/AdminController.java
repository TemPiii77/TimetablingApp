package org.example.backend.controller;

import org.example.backend.domain.User;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/teszt")
    public void teszt() {
        UserDto userDto = new UserDto("AABBCC","valami","kiss","bela","abc","admin");

        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

}
