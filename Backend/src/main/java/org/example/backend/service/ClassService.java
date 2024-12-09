package org.example.backend.service;

import org.example.backend.domain.Class;
import org.example.backend.domain.Classroom;
import org.example.backend.domain.User;
import org.example.backend.dto.ClassDto;
import org.example.backend.dto.ClassroomDto;
import org.example.backend.dto.UserDto;
import org.example.backend.repository.ClassRepository;
import org.example.backend.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    private ClassRepository classRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setClassRepository(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<ClassDto> getClasses() {
        return classRepository.findAll().stream().map((e) -> modelMapper.map(e, ClassDto.class)).toList();
    }

    public ClassDto getClass(Integer id) {
        return classRepository.findById(id).map((e) -> modelMapper.map(e, ClassDto.class)).orElse(null);
    }

    public void saveClass(ClassDto classroomDto) {
        org.example.backend.domain.Class aClass = modelMapper.map(classroomDto, org.example.backend.domain.Class.class);
        classRepository.save(aClass);
    }

    public void updateClass(ClassDto classDto) {
        org.example.backend.domain.Class aClass = modelMapper.map(classDto, org.example.backend.domain.Class.class);
        classRepository.save(aClass);
    }

    public void deleteClass(Integer id) {
        classRepository.deleteById(id);
    }

    public List<ClassDto> getStudentsClasses(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return classRepository.findClassesByStudentId(user.getId()).stream().map((e) -> modelMapper.map(e, ClassDto.class)).toList();
    }
}
