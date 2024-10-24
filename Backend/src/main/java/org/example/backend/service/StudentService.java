package org.example.backend.service;

import org.example.backend.domain.Admin;
import org.example.backend.domain.Student;
import org.example.backend.domain.Teacher;
import org.example.backend.domain.User;
import org.example.backend.dto.StudentDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.StudentRepository;
import org.example.backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<StudentDto> getStudents() {
        return studentRepository.findAll().stream().map((e) -> modelMapper.map(e, StudentDto.class)).toList();
    }

}
