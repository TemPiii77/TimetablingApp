package org.example.backend.service;

import org.example.backend.domain.*;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.ClassroomRepository;
import org.example.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public void saveUser(UserDto userDto, String roleBasedInformation) {
        User user = modelMapper.map(userDto, User.class);

        switch (userDto.getRole()) {
            case "ROLE_TEACHER":
                user.setTeacher(new Teacher(user.getId()), roleBasedInformation);
                break;
            case "ROLE_ADMIN":
                user.setAdmin(new Admin(user.getId()));
                break;
            default:
                user.setStudent(new Student(user.getId()));
        }

        userRepository.save(user);
    }

    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map((e) -> modelMapper.map(e, UserDto.class)).toList();
    }

    public UserDto getUser(String id) {
        return userRepository.findById(id).map((e) -> modelMapper.map(e, UserDto.class)).orElse(null);
    }


    public void updateUser(UserDto userDto, String roleBasedInformation) {
        User user = modelMapper.map(userDto, User.class);

        switch (userDto.getRole()) {
            case "ROLE_TEACHER":
                user.setTeacher(new Teacher(user.getId()), roleBasedInformation);
                break;
            case "ROLE_ADMIN":
                user.setAdmin(new Admin(user.getId()));
                break;
            default:
                user.setStudent(new Student(user.getId()));
        }

        userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }




}

