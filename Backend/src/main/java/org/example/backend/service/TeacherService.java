package org.example.backend.service;

import org.example.backend.domain.Admin;
import org.example.backend.domain.Student;
import org.example.backend.domain.Teacher;
import org.example.backend.domain.User;
import org.example.backend.dto.StudentDto;
import org.example.backend.dto.TeacherDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.StudentRepository;
import org.example.backend.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<TeacherDto> getTeachers() {
        return teacherRepository.findAll().stream().map((e) -> modelMapper.map(e, TeacherDto.class)).toList();
    }

    public void updateTeacher(TeacherDto teacherDto) {
        Teacher teacher = modelMapper.map(teacherDto, Teacher.class);
        teacherRepository.save(teacher);
    }
}
